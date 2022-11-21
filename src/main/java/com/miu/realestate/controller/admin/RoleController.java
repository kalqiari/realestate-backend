package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.response.RoleDto;
import com.miu.realestate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/v1/roles")
    public List<RoleDto> getRoles(){
        return roleService.findAll();
    }

    @GetMapping("/v1/role/{id}")
    public RoleDto getRole(@PathVariable("id" ) Long id) {
        return roleService.findById(id);
    }

}
