package com.miu.realestate.repo;

import com.miu.realestate.entity.Role;
import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface UserRepo extends CrudRepository<User, Long> {
    User findUserByEmailIs(String email);

    @Query("from User u where u.role=:customer and u.createdAt>:now and u.createdAt< :nowPlus10")
    List<User> findTop10ByRoleEqualsOrderByCreatedAtDesc(Role customer, LocalDate now, LocalDate nowPlus10);

    List<User> findAll();


    User findByUsername(String username);
}
