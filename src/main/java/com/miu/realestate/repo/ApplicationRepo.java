package com.miu.realestate.repo;

import com.miu.realestate.entity.Application;

import com.miu.realestate.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApplicationRepo extends CrudRepository<Application,Long> {

    List<Application> findAll();
    
    List<Application> findAllByCreatedAt(LocalDate submittedAt);

    List<Application> findApplicationByProperty(Property property);

    List<Application> findApplicationByPropertyStateAndPropertyCity(String state, String city);

    List<Application> findByCreatedAt(LocalDate submittedAt);
    @Query("SELECT A from Application A where A.user.id = :userId")
    List<Application> findByUserID(Long userId);
    @Query("SELECT A from Application A where A.property.user.id = :ownerId")
    List<Application> findByOwnerId(Long ownerId);
}
