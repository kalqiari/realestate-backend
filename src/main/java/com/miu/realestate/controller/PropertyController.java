package com.miu.realestate.controller;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @RolesAllowed("owner")
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

    @PreAuthorize("hasRole('OWNER')")
    @DeleteMapping("/{id}")
    public void unList(@PathVariable Long id) {
        PropertyDto property = getById(id);
        if(property!=null && !(property.getStatus().equalsIgnoreCase("pending"))){
            propertyService.delete(id);
        }
    }

    @PreAuthorize("hasRole('OWNER')")
    @PutMapping("/{id}")
    public void edit(@PathVariable("id") Long id, @RequestBody PropertyDto propertyDto) {
       propertyService.update(id, propertyDto);
    }

    @PreAuthorize("hasRoles('OWNER', 'CUSTOMER')")
    @GetMapping("/filterPropertyByNoOfRooms")
    public List<PropertyDto> findAllByNoOfBedRoom(@RequestParam int noOfRoom){
        return propertyService.findAllByNoOfBedRoom(noOfRoom);
    }

    @PreAuthorize("hasRoles('OWNER', 'CUSTOMER')")
    @GetMapping("/filterPropertyByAddress")
    public List<PropertyDto> findAllByAddressStateAndAddressCity(@RequestParam(required = false) String state, @RequestParam(required = false) String city){
        return propertyService.findAllByAddressStateAndAddressCity(state, city);
    }

    @PreAuthorize("hasRoles('owner', 'customer')")
    @GetMapping("/filterPropertyByType")
    public List<PropertyDto> findAllByPropertyType(@RequestParam("type") String type){
        return propertyService.findAllByPropertyType(type);
    }
}
