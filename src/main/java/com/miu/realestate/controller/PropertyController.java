package com.miu.realestate.controller;

import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public void update(@PathVariable("id") Long id, @RequestBody PropertyDto propertyDto) {
       propertyService.update(id, propertyDto);
    }

    @GetMapping("/filterPropertyByNoOfRooms")
    public List<PropertyDto> findAllByNoOfBedRoom(@RequestParam int noOfRoom){
        return propertyService.findAllByNoOfBedRoom(noOfRoom);
    }

    @GetMapping("/filterPropertyByAddress")
    public List<PropertyDto> findAllByAddressStateAndAddressCity(@RequestParam(required = false) String state,
                                                                                   @RequestParam(required = false) String city){
        return propertyService.findAllByAddressStateAndAddressCity(state, city);
    }

    @GetMapping("/filterPropertyByType")
    public List<PropertyDto> findAllByPropertyType(@RequestParam("type") String type){
        return propertyService.findAllByPropertyType(type);
    }
}
