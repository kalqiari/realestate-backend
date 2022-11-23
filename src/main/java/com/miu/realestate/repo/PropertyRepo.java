package com.miu.realestate.repo;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.response.PropertyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

    List<Property> findAll();
    List<Property> findAllByNoOfBedRoom(int noOfRoom);

    List<Property> findAllByAddressStateAndAddressCity(String state);

    List<Property> findAllByPropertyType(String type);



}
