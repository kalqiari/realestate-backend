package com.miu.realestate.service.impl;
import com.miu.realestate.entity.Application;
import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.request.ApplicationRequestDto;
import com.miu.realestate.entity.dto.response.ApplicationDto;
import com.miu.realestate.repo.ApplicationRepo;
import com.miu.realestate.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationServiceImpl( ApplicationRepo applicationRepo){
        this.applicationRepo = applicationRepo;
    }


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(ApplicationRequestDto applicationDto) {
        applicationRepo.save(modelMapper.map(applicationDto, Application.class));
    }

    @Override
    public void delete(Long application_id) {
        applicationRepo.deleteById(application_id);
    }

    @Override
    public ApplicationDto getById(Long application_id) {
        return modelMapper.map(applicationRepo.findById(application_id), ApplicationDto.class);
    }

    @Override
    public List<ApplicationDto> getAll() {


        List<Application> applications = applicationRepo.findAll();
        return applications
                .stream()
                .map(application  -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id, ApplicationDto applicationDto) {
        applicationDto.setId(id);
        applicationRepo.save(modelMapper.map(applicationDto, Application.class));

    }

    @Override
    public List<ApplicationDto> findAllByCreatedAt(LocalDate submittedAt) {
        List<Application> applications = applicationRepo.findByCreatedAt(submittedAt);
        return applications
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> findApplicationByProperty(Property property) {
        List<Application> applications = applicationRepo.findApplicationByProperty(property);
        return applications
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> findApplicationByPropertyStateAndPropertyCity(String state, String city) {
        List<Application> applications = applicationRepo.findApplicationByPropertyStateAndPropertyCity(state,city);
        return applications
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> findByUserID(Long userId) {
        List<Application> applications = applicationRepo.findByUserID(userId);
        return applications
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> findByOwnerId(Long ownerId) {
        List<Application> applications = applicationRepo.findByOwnerId(ownerId);
        return applications
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }
}
