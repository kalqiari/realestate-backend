package com.miu.realestate.repo;

import com.miu.realestate.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Long> {
}
