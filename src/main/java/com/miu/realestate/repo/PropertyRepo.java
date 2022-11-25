package com.miu.realestate.repo;

import com.miu.realestate.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long> {

    List<Property> findAll();


    List<Property> findByBedrooms(int noOfRoom);

    List<Property> findByStateAndCity(String state, String city);

    List<Property> findByHomeType(String type);

    List <Property> findPropertyByPropertyStatus(String propertyStatus);

    List <Property> findPropertyByPrice(double price);

    List<Property> findPropertyByHomeType(String homeType);



}
