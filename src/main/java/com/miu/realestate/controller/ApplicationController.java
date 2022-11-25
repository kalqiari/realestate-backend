package com.miu.realestate.controller;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.request.ApplicationRequestDto;
import com.miu.realestate.entity.dto.response.ApplicationDto;
import com.miu.realestate.service.ApplicationService;
import com.miu.realestate.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    private  ApplicationService applicationService;
    private UserService userService;
    private ModelMapper modelMapper;
    @Autowired
    public ApplicationController(ApplicationService applicationService, UserService userService, ModelMapper modelMapper) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @RolesAllowed("customer")
    @PostMapping
    public void save(@RequestBody ApplicationRequestDto applicationDto, Principal principal) {
        applicationDto.setUserId(userService.findByUsername(principal.getName()).getId());
        applicationDto.setCreatedAt(LocalDate.now());
       applicationService.save(applicationDto);
    }

    @RolesAllowed({"owner", "customer"})
    @GetMapping
    public List<ApplicationDto> getAll(Principal principal) {
        var user = userService.findByUsername(principal.getName());

        if(user.getRoleId() == 3)
          return applicationService.findByUserID(user.getId());
        else if(user.getRoleId() == 2)
        return applicationService.findByOwnerId(user.getId());
        else
            return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDto> getById(@PathVariable Long id) {
        var application = applicationService.getById(id);
        return ResponseEntity.ok(application);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        applicationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long application_id, @RequestBody ApplicationDto applicationDto) {
        applicationService.update(application_id, applicationDto);
    }
    @RolesAllowed("owner")
    @GetMapping("/filterBySubmissionDate")
    public List<ApplicationDto> findAllByCreatedAt(@RequestParam("submittedAt")LocalDate submittedAt) {
        return applicationService.findAllByCreatedAt(submittedAt);
    }
    @RolesAllowed("owner")
    @GetMapping("/filterByLocation")
    public List<ApplicationDto> findApplicationByPropertyStateAndPropertyCity(@RequestParam String state, String city) {
        return applicationService.findApplicationByPropertyStateAndPropertyCity(state, city);
    }

    @RolesAllowed("owner")
    @GetMapping("/filterByProperty")
    public List<ApplicationDto> findApplicationByProperty(@RequestParam Property property) {
        return applicationService.findApplicationByProperty(property);
    }

}
