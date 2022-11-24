package com.miu.realestate.controller.admin;


import com.miu.realestate.entity.User;
import com.miu.realestate.entity.dto.response.UserDto;
import com.miu.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping()
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.findByIdDto(id);
    }

    @RolesAllowed("admin")
    @PutMapping("/activateDeactivateUser")
    public void activateDeactivateUser(@PathVariable Long id ){
        var user = userService.findById(id);
        if(!user.isActiveStatus()){
            user.setActiveStatus(true);
        }else{
            user.setActiveStatus(false);
        }


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
    @RolesAllowed("admin")
    @GetMapping("/top10RecentCustomers")
    public List<User>findRecentCustomers(){
        return userService.findTop10RecentCustomers();
    }
}
