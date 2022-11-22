package com.miu.realestate.repo;

import com.miu.realestate.entity.Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends CrudRepository<Application,Long> {

    List<Application> findAll();

}
