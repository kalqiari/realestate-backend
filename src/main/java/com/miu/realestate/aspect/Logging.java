package com.miu.realestate.aspect;

import com.miu.realestate.entity.dto.response.LogDto;
import com.miu.realestate.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;

@Aspect
@Component
public class Logging {

    @Autowired
    LogService logService;

    @Pointcut("execution( * *.*.realestate.controller.*.*.*(..))")

    public void logMe() {
    }

    @Around("logMe()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable e) {
            throw e;
        }
        finally {
            saveLog(point, beginTime);
        }

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogDto applicationLog = new LogDto();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        applicationLog.setMethod(request.getMethod());
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                if(!paramNames[i].equals("principal"))
                params += "  " + paramNames[i] + ": " + args[i];
            }
            applicationLog.setParams(params);
        }
        applicationLog.setEndPoint(request.getServletPath());
        applicationLog.setPrincipal(SecurityContextHolder.getContext().getAuthentication().getName());
        applicationLog.setRequestTime(Instant.ofEpochMilli(time)
                .atZone(ZoneId.of("America/Chicago")).toLocalDateTime());
        applicationLog.setOperation(className + "." + methodName + "()");
        logService.save(applicationLog);
    }
}