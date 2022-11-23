package com.miu.realestate.repo;

import com.miu.realestate.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepo extends CrudRepository<User, Long> {
    static User findByEmail(String email);

    List<User> findTop10ByRoleEqualsOrderByAccountCreatedAtDesc(String role);

    List<User> findAll();
}
