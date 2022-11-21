package com.miu.realestate.repository;

import com.miu.realestate.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Integer> {
}
