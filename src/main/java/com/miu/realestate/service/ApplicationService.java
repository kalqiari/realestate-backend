package com.miu.realestate.service;

import com.miu.realestate.entity.Application;
import com.miu.realestate.entity.dto.ApplicationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationService {

    void save(ApplicationDto p);

    void delete(Long application_id);

    ApplicationDto getById(Long application_id);

    List<ApplicationDto> getAll();
}
