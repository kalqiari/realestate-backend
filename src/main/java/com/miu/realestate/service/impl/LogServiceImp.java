package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.dto.response.LogDto;
import com.miu.realestate.entity.Log;
import com.miu.realestate.repo.LogRepo;
import com.miu.realestate.service.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImp implements LogService {

    private LogRepo logRepo;

    @Autowired
    public LogServiceImp( LogRepo logRepo){
        this.logRepo = logRepo;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(LogDto log) {
        logRepo.save(modelMapper.map(log, Log.class));
    }
}