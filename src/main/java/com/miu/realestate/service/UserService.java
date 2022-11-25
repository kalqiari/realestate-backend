package com.miu.realestate.service;

import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto findByIdDto(Long id);

    void deleteById(Long id);

//    List<UserDto> findByRole(Role role);

    void save(UserDto userDto);

    void update(Long userId, UserDto userDto);

    List<UserDto> findTop10RecentCustomers();
}
