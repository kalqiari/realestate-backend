package com.miu.realestate.service;

import com.miu.realestate.entity.dto.PropertyDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PropertyService {

    public void save (PropertyDto propertyDto);
    public void delete(Long id);
    public PropertyDto getById(Long id);
    public List <PropertyDto> getAll();
    public void update(Long id, PropertyDto propertyDto);


}
