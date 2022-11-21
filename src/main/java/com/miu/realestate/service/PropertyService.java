package com.miu.realestate.service;

import com.miu.realestate.entity.dto.PropertyDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PropertyService {

    void save (PropertyDto propertyDto);
    void delete(Long id);
    PropertyDto getById(Long id);
    List <PropertyDto> getAll();
    void update(Long id, PropertyDto propertyDto);


}
