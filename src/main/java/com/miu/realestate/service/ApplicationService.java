package com.miu.realestate.service;

import com.miu.realestate.entity.Application;
import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.request.ApplicationRequestDto;
import com.miu.realestate.entity.dto.response.ApplicationDto;

import java.time.LocalDate;
import java.util.List;


public interface ApplicationService {

    void save(ApplicationRequestDto p);

    void delete(Long application_id);

    ApplicationDto getById(Long application_id);

    List<ApplicationDto> getAll();

    void update(Long id, ApplicationDto applicationDto);

    List<ApplicationDto> findAllByCreatedAt(LocalDate submittedAt);

    List<ApplicationDto> findApplicationByProperty(Property property);

    List<ApplicationDto> findApplicationByPropertyStateAndPropertyCity(String state, String city);

    List<ApplicationDto> findByUserID(Long userId);

    List<ApplicationDto> findByOwnerId(Long ownerId);

}
