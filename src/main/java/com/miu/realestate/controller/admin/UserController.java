package com.miu.realestate.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
@Slf4j
@RequestMapping("/admin")
@RestController
public class UserController {
    private final KeycloakSecurityContext securityContext;
    private final AccessToken accessToken;
    @Autowired
    public UserController(KeycloakSecurityContext securityContext, AccessToken accessToken) {
        this.securityContext = securityContext;
        this.accessToken = accessToken;
    }

    @RolesAllowed("admin")
    @GetMapping("/test")
    public String test(Principal principal){
         log.info("principal: " + principal.getName());
      return "test";
    }
}
