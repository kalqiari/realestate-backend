package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.repo.UserRepo;
import com.miu.realestate.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {

        var users = userRepo.findAll();

        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {

        return modelMapper.map(userRepo.findById(id).get(), UserDto.class) ;
    }

    @Override
    public UserDto findByIdDto(Long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void update(Long userId, UserDto userDto) {
        userDto.setId(userId);
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public List<UserDto> findTop10RecentCustomers() {
        List<User> users = userRepo.findTop10ByRoleEqualsOrderByCreatedAtDesc(3);
        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public UserDto findByUsername(String name) {
       return modelMapper.map(userRepo.findByUsername(name), UserDto.class);
    }
}
