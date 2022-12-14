package com.miu.realestate.repo;

import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepo extends CrudRepository<User, Long> {
    User findUserByEmailIs(String email);

    List<User> findTop10ByRoleIdEqualsOrderByCreatedAtDesc(Long roleId);

    List<User> findAll();


    User findByUsername(String username);
}
