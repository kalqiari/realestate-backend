package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.repo.PropertyRepo;
import com.miu.realestate.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepo propertyRepo;
    @Autowired
    public PropertyServiceImpl( PropertyRepo propertyRepo){
        this.propertyRepo = propertyRepo;
    }

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void save(PropertyDto propertyDto) {
        propertyRepo.save(modelMapper.map(propertyDto,Property.class));
    }

    @Override
    public void delete(Long id) {
        PropertyDto property = getById(id);
        if(property!=null && property.getStatus().equalsIgnoreCase("pending")) {
            propertyRepo.deleteById(id);
        }
    }

    @Override
    public PropertyDto getById(Long id) {
        List<Property> properties = propertyRepo.findAll();
        return properties
                .stream()
                .map(p -> modelMapper.map(p, PropertyDto.class))
                .filter(p -> p.getId() ==id)
                .findFirst()
                .orElse(null);

       return modelMapper.map(propertyRepo.findById(id), PropertyDto.class);
    }

    @Override
    public List<PropertyDto> getAll() {
        List<Property> properties = propertyRepo.findAll();
        return properties
                .stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id, PropertyDto propertyDto) {
        propertyDto.setId(id);
        propertyRepo.save(modelMapper.map(propertyDto, Property.class));
    }

    public List<PropertyDto> findAllByNoOfBedRoom(int noOfBedRoom) {
        List<Property> properties = propertyRepo.findAllByNoOfBedRoom(noOfBedRoom);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findAllByAddressStateAndAddressCity(String state, String city) {
        List<Property> properties = propertyRepo.findAllByAddressStateAndAddressCity(state);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findAllByPropertyType(String type) {
        List<Property> properties = propertyRepo.findAllByPropertyType(type);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }
}
