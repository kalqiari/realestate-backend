package com.miu.realestate.service;

import com.miu.realestate.entity.Application;
import com.miu.realestate.entity.dto.ApplicationDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ApplicationService {

   public void save(ApplicationDto p);

   public void delete(Long application_id);

    ApplicationDto getById(Long application_id);

    List<ApplicationDto> getAll();

    void update(Long id, ApplicationDto applicationDto);
}
