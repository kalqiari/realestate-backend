package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.dto.ApplicationDto;
import com.miu.realestate.repository.ApplicationRepo;
import com.miu.realestate.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(ApplicationDto applicationDto) {
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
        return null;
    }

    @Override
    public void update(Long id, ApplicationDto applicationDto) {
    }
}
