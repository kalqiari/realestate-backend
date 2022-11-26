package com.miu.realestate.controller;

import com.miu.realestate.entity.Email;
import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.request.ApplicationRequestDto;
import com.miu.realestate.entity.dto.response.ApplicationDto;
import com.miu.realestate.service.ApplicationService;
import com.miu.realestate.service.EmailService;
import com.miu.realestate.service.PropertyService;
import com.miu.realestate.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    private  ApplicationService applicationService;
    private UserService userService;
    private PropertyService propertyService;
    private ModelMapper modelMapper;

    private EmailService emailservice;
    @Autowired
    public ApplicationController(ApplicationService applicationService, UserService userService, PropertyService propertyService, ModelMapper modelMapper, EmailService emailservice) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.propertyService = propertyService;
        this.modelMapper = modelMapper;
        this.emailservice = emailservice;
    }
    @RolesAllowed("customer")
    @PostMapping
    public void save(@RequestBody ApplicationRequestDto applicationDto, Principal principal) {
        applicationDto.setUserId(userService.findByUsername(principal.getName()).getId());
        applicationDto.setCreatedAt(LocalDate.now());
        applicationService.save(applicationDto);
        var p = propertyService.getById(applicationDto.getPropertyId());
        var u = userService.findById(p.getUserId());
        Email email = new Email();
        email.setTo(u.getEmail());
        email.setFrom("testp34109@gmail.com");
        email.setSubject("New Application");
        email.setContent("Hi "+ u.getFirstName() +", You have new offer please check the website.");
        emailservice.sendEmail(email);

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
    @RolesAllowed("owner")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long application_id, @RequestBody ApplicationDto applicationDto) {
        applicationService.update(application_id, applicationDto);
    }
    @RolesAllowed("owner")
    @PutMapping("/{id}/accept")
    public void accept(@PathVariable("id") Long application_id) {
        var a = applicationService.getById(application_id);
        a.setReviewStatus("Accepted");
       var app = applicationMapper(a);
        var property = a.getProperty();
        property.setStatus("Contingent");
        a.setProperty(null);
        propertyService.save(property);
        applicationService.save(app);
    }

    @RolesAllowed("owner")
    @PutMapping("/{id}/reject")
    public void reject(@PathVariable("id") Long application_id) {
        var a = applicationService.getById(application_id);
        a.setReviewStatus("Rejected");
        var app = applicationMapper(a);
        var property = a.getProperty();
        property.setStatus("Available");
        propertyService.save(property);
        applicationService.save(app);
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

    private ApplicationRequestDto applicationMapper(ApplicationDto a)
    {
        ApplicationRequestDto app = new ApplicationRequestDto();
        app.setId(a.getId());
        app.setApplicationType(a.getApplicationType());
        app.setCreatedAt(a.getCreatedAt());
        app.setUserId(a.getUser().getId());
        app.setReviewStatus(a.getReviewStatus());
        app.setMessage(a.getMessage());
        app.setEmploymentInfo(a.getEmploymentInfo());
        app.setPropertyId(a.getPropertyId());
        app.setReviewedAt(LocalDate.now());
        return app;
    }
}
