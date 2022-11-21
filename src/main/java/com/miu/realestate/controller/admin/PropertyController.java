package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.PropertyDto;
import com.miu.realestate.service.Impl.PropertyServiceImpl;
import com.miu.realestate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public void save(@RequestBody PropertyDto propertyDto) {
       propertyService.save(propertyDto);
    }

    @GetMapping
    public List<PropertyDto> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDto> getById(@PathVariable Long id) {
        var property = propertyService.getById(id);
        return ResponseEntity.ok(property);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        propertyService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id) {
        //call service
    }
}
