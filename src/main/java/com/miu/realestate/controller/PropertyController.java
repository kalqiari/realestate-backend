package com.miu.realestate.controller;

import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping
    public void save(@RequestBody PropertyDto propertyDto) {
       propertyService.save(propertyDto);
    }

    @GetMapping
    public List<PropertyDto> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/{id}")
    public PropertyDto getById(@PathVariable Long id) {
        return propertyService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        propertyService.delete(id);
    }

    @PreAuthorize("hasRole('OWNER')")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody PropertyDto propertyDto) {
       propertyService.update(id, propertyDto);
    }
}
