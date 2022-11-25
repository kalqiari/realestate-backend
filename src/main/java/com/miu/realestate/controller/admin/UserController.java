package com.miu.realestate.controller.admin;


import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping()
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @RolesAllowed("admin")
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id){

        return userService.findByIdDto(id);
    }

    @RolesAllowed("admin")
    @PutMapping("/activateDeactivateUser/{id}")
    public void activateDeactivateUser(@PathVariable Long id, @RequestBody UserDto userDto ){
        var user = userService.findById(id);

        user.setStatus(userDto.isStatus());
        userService.save(user);

    }

    @RolesAllowed("admin")
    @PostMapping()
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @RolesAllowed("admin")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @RolesAllowed("admin")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }


    @GetMapping("/top10RecentCustomers")
    public List<UserDto> findRecentCustomers(){
        return userService.findTop10RecentCustomers();
    }
}
