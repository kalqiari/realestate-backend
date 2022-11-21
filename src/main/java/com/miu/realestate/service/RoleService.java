package com.miu.realestate.service;


import com.miu.realestate.entity.dto.response.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();

    RoleDto findById(Long id);

}
