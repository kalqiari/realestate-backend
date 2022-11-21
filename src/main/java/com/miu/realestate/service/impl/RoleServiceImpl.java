package com.miu.realestate.service.impl;

import com.miu.realestate.entity.dto.response.RoleDto;
import com.miu.realestate.repo.RoleRepo;
import com.miu.realestate.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<RoleDto> findAll() {
        var roles = roleRepo.findAll();
        return roles
                .stream()
                .map(role -> modelMapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Long id) {
        return modelMapper.map(roleRepo.findById(id), RoleDto.class);
    }
}
