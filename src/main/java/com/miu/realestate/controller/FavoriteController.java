package com.miu.realestate.controller;
import com.miu.realestate.entity.dto.response.FavoriteDto;
import com.miu.realestate.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/favorites")
@RestController
public class FavoriteController {

    private  FavoriteService favoriteService;
    @Autowired
    public FavoriteController( FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }
    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping()
    public List<FavoriteDto> getFavorites() {
        return favoriteService.findAll();
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/{id}")
    public FavoriteDto getFavorite(@PathVariable("id") Long id) {
        return favoriteService.findByPropertyId(id);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping()
    public void save(@RequestBody FavoriteDto favoriteDto) {
        favoriteService.save(favoriteDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        favoriteService.deleteById(id);
    }
}

