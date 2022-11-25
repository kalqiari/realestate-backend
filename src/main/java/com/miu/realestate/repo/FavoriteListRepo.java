package com.miu.realestate.repo;

import com.miu.realestate.entity.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteListRepo extends CrudRepository<FavoriteList, Long> {

    List<FavoriteList> findByUserId(Long id);
}
