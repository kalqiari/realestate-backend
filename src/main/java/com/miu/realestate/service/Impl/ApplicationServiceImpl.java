package com.miu.realestate.service.Impl;
import com.miu.realestate.entity.Application;
import com.miu.realestate.entity.dto.response.ApplicationDto;
import com.miu.realestate.repo.ApplicationRepo;
import com.miu.realestate.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(ApplicationDto applicationDto) {
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
        applicationDto.setApplicationId(id);
        applicationRepo.save(modelMapper.map(applicationDto, Application.class));

    }
}
