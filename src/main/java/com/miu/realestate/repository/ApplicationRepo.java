package com.miu.realestate.repository;

import com.miu.realestate.entity.Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends CrudRepository<Application,Long> {
}
