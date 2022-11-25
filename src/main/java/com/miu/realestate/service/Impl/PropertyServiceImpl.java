package com.miu.realestate.service.impl;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.repo.PropertyRepo;
import com.miu.realestate.repo.UserRepo;
import com.miu.realestate.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepo propertyRepo;

    UserRepo userRepo;

    @Autowired
    public PropertyServiceImpl( PropertyRepo propertyRepo, UserRepo userRepo){
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
    }

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void save(PropertyDto propertyDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findUserByEmailIs(username);
        Property property = modelMapper.map(propertyDto,Property.class);
        property.setUser(user);
        property.setStatus("Available");
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
        List<Property> properties = propertyRepo.findByBedrooms(noOfBedRoom);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findAllByAddressStateAndAddressCity(String state, String city) {

        List<Property> properties = propertyRepo.findByStateAndCity(state, city);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList()) ;

    }

    @Override
    public List<PropertyDto> findAllByPropertyType(String type) {
        List<Property> properties = propertyRepo.findByHomeType(type);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findPropertyByLastTenRented (String propertyStatus) {
        var property = propertyRepo.findPropertyByPropertyStatus(propertyStatus);
        return property.stream()
                .filter(status -> status.getPropertyStatus().equalsIgnoreCase("rented"))
                .sorted((o1, o2) -> o2.getSoldRentedAt().compareTo(o1.getSoldRentedAt()))
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findPropertyByPrice(double price) {
        List<Property> properties = propertyRepo.findPropertyByPrice(price);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findPropertyByHomeType(String homeType) {
        List<Property> properties = propertyRepo.findPropertyByHomeType(homeType);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findPropertiesFavoriteByUserId(Long id) {
        List<Property> properties = propertyRepo.findPropertiesFavoriteByUserId(id);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> findPropertyByUserId(Long id) {
        List<Property> properties = propertyRepo.findPropertyByUserId(id);
        return properties
                .stream()
                .map(post -> modelMapper.map(post,PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> filter(String criteria, String input) {
        List<Property> properties;
        if (criteria == null)
        {
            properties  = propertyRepo.findAll();
        }
        else if (criteria.equals("city"))
        {
            properties  = propertyRepo.findByCity(input);
        }
        else if (criteria.equals("state"))
        {
            properties  = propertyRepo.findByState(input);
        }else if(criteria.equals("price")){
            properties  = propertyRepo.findByPriceLessThan(Double.parseDouble(input));
        }
        else if(criteria.equals("zipcode")){
            properties  = propertyRepo.findByZipcode(input);
        }
        else if(criteria.equals("numberOfRooms"))
        {
            properties  = propertyRepo.findByBedrooms(Integer.parseInt(input));
        }
        else if(criteria.equals("homeType"))
        {
            properties  = propertyRepo.findByHomeType(input);
        }
        else {
            properties  = propertyRepo.findAll();
        }
        return properties
                .stream()
                .map(post -> modelMapper.map(post, PropertyDto.class))
                .collect(Collectors.toList());
    }
}
