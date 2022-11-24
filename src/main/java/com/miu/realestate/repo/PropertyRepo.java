package com.miu.realestate.repo;

import com.miu.realestate.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long> {

    List<Property> findAll();
    
    List<Property> findAllByNoOfBedRoom(int noOfRoom);

    List<Property> findAllByAddressStateAndAddressCity(String state);

    List<Property> findAllByPropertyType(String type);

    List <Property> findPropertyByPropertyStatus(String propertyStatus);

    String findByEmail(String username);

    List <Property> findPropertyByPrice(double price);

    List<Property> findPropertyByHomeType(String homeType);
}
