package com.miu.realestate.repo;

import com.miu.realestate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
}
