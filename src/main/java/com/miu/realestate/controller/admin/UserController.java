package com.miu.realestate.controller.admin;


import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.findByIdDto(id);
    }

    @PostMapping()
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }
}
