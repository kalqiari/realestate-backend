package com.miu.realestate.controller;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.response.ApplicationDto;
import com.miu.realestate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    private  ApplicationService applicationService;
    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public void save(@RequestBody ApplicationDto applicationDto) {
       applicationService.save(applicationDto);
    }

    @GetMapping
    public List<ApplicationDto> getAll() {
        return applicationService.getAll();
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
