package com.miu.realestate.service;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.response.PropertyDto;

import java.util.List;

public interface PropertyService {

    public void save (PropertyDto propertyDto);
    public void delete(Long id);
    public PropertyDto getById(Long id);
    public List <PropertyDto> getAll();
    public void update(Long id, PropertyDto propertyDto);


    List<PropertyDto> findAllByNoOfBedRoom(int noOfRoom);

    List<PropertyDto> findAllByAddressStateAndAddressCity(String state, String city);

    List<PropertyDto> findAllByPropertyType(String type);
    List <PropertyDto> findPropertyByPropertyStatus(String propertyStatus);
}
