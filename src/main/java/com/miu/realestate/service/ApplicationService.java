package com.miu.realestate.service;

import com.miu.realestate.entity.dto.response.ApplicationDto;

import java.util.List;


public interface ApplicationService {

    void save(ApplicationDto p);

    void delete(Long application_id);

    ApplicationDto getById(Long application_id);

    List<ApplicationDto> getAll();

    void update(Long id, ApplicationDto applicationDto);
}
