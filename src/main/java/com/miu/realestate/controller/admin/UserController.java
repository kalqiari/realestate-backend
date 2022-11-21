package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/v1/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/v1/users/{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.findByIdDto(id);

    }

    @PostMapping("/v1/users")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/v1/users/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/v1/users/{id}")
    public void update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }
}
