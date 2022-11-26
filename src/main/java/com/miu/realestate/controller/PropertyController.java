package com.miu.realestate.controller;

import com.miu.realestate.entity.dto.response.FavoriteDto;
import com.miu.realestate.entity.dto.response.FavoriteListDto;
import com.miu.realestate.entity.dto.response.PropertyDto;
import com.miu.realestate.service.FavoriteListService;
import com.miu.realestate.service.FavoriteService;
import com.miu.realestate.service.PropertyService;
import com.miu.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private FavoriteListService favoriteListService;
    private FavoriteService favoriteService;
    private UserService userService;

    private PropertyService propertyService;

    @Autowired
    public PropertyController(FavoriteListService favoriteListService, FavoriteService favoriteService, UserService userService, PropertyService propertyService) {
        this.favoriteListService = favoriteListService;
        this.favoriteService = favoriteService;
        this.propertyService = propertyService;
        this.userService = userService;
    }

    @RolesAllowed("owner")
    @PostMapping
    public void save(@RequestBody PropertyDto propertyDto, Principal principal) {
      var user= userService.findByUsername(principal.getName());
        propertyDto.setUserId(user.getId());
        propertyService.save(propertyDto);
    }

    @GetMapping
    public List<PropertyDto> getAll(Principal principal,
                                    @RequestParam(value = "favorite", required = false) Boolean favorite, @RequestParam(value = "filter", required = false) String criteria, @RequestParam(value = "input", required = false) String input )
    {
       if(principal != null) {
           var user = userService.findByUsername(principal.getName());
           if (user != null && user.getRoleId() == 3 && favorite != null)
               return propertyService.findPropertiesFavoriteByUserId(user.getId());
           else if (user != null && user.getRoleId() == 2 ){
               return propertyService.findPropertyByUserId(user.getId());
           }
           else
               return propertyService.filter(criteria, input);
       }
        return propertyService.filter(criteria, input);
    }

    @GetMapping("/{id}")
    public PropertyDto getById(@PathVariable Long id,Principal principal ) {

        var p =  propertyService.getById(id);
        if(principal != null && p != null ) {

            var user = userService.findByUsername(principal.getName());
            if(user.getRoleId() == 3) {
                p.setViews(p.getViews() + 1);
                propertyService.save(p);
            }
        }

        return p;
    }
    @RolesAllowed("customer")
    @PutMapping("/{property_id}/favoriteToggle")
    public void favoriteToggle(@PathVariable Long property_id, Principal principal){

        var user = userService.findByUsername(principal.getName());

       if(user != null){
           var favorite = favoriteService.findByPropertyIdAndUserId(property_id, user.getId());
            if(favorite != null){
                favoriteService.deleteById(favorite.getId());
            }else{
                var favoriteDto = new FavoriteDto();
                favoriteDto.setUserId(user.getId());
                favoriteDto.setPropertyId(property_id);

               var favoriteList = favoriteListService.findByUserId(user.getId());
               if(favoriteList.size() != 0 ){
                   favoriteDto.setFavoriteListId(favoriteList.get(0).getId());
                   favoriteService.save(favoriteDto);
               }else{

                   FavoriteListDto list = new FavoriteListDto();
                  list.setListName("default");
                  list.setUserId(user.getId());

                  favoriteListService.save(list);
                   FavoriteListDto newList = favoriteListService.findByUserId(user.getId()).get(0);

                   favoriteDto.setFavoriteListId(newList.getId());
                  favoriteService.save(favoriteDto);
               }

            }
       }

    }

    @RolesAllowed("owner")
    @DeleteMapping("/{id}")
    public void unList(@PathVariable Long id) {
        PropertyDto property = propertyService.getById(id);
        if(property != null && !property.getStatus().equals("Pending")){
            propertyService.delete(id);
        }
    }


    @RolesAllowed("owner")
    @PutMapping("/{id}")
    public void edit(@PathVariable("id") Long id, @RequestBody PropertyDto propertyDto) {
       propertyService.update(id, propertyDto);
    }

    @RolesAllowed({"owner", "customer"})
    @GetMapping("/filterPropertyByNoOfRooms")
    public List<PropertyDto> findAllByNoOfBedRoom(@RequestParam int noOfRoom){
        return propertyService.findAllByNoOfBedRoom(noOfRoom);
    }

    static int views = 0;
    @RolesAllowed({"owner", "customer"})
    @GetMapping("/filterPropertyByAddress")
    public List<PropertyDto> findAllByAddressStateAndAddressCity(@RequestParam(required = false) String state, @RequestParam(required = false) String city){
        views++;
        return propertyService.findAllByAddressStateAndAddressCity(state, city);
    }
    @RolesAllowed({"owner"})
    @GetMapping("/displayViewsByAddress")
    public int displayViews(){
        return views;
    }

    @RolesAllowed({"owner", "customer"})
    @GetMapping("/filterPropertyByType")
    public List<PropertyDto> findAllByPropertyType(@RequestParam("type") String type){
        return propertyService.findAllByPropertyType(type);


    }
    @RolesAllowed("admin")
    @GetMapping("/findPropertyByPropertyStatus")
    public List<PropertyDto> findPropertyByLastTenRented(){
        return propertyService.findPropertyByLastTenRented();
    }
    @RolesAllowed({"customer", "owner"})
    @GetMapping("/filterByPrice")
    public List<PropertyDto> findPropertyByPrice(@RequestParam("price") double price) {
        return propertyService.findPropertyByPrice(price);
    }

    @GetMapping("/filterByHomeType")
    @RolesAllowed({"customer", "owner"})
    public List<PropertyDto> findPropertyByHomeType(@RequestParam String homeType){
        return propertyService.findPropertyByHomeType(homeType);
    }
}
