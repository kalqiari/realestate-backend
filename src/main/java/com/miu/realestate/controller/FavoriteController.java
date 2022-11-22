package com.miu.realestate.controller;
import com.miu.realestate.entity.dto.response.FavoriteDto;
import com.miu.realestate.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/favorites")
@RestController
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @GetMapping()
    public List<FavoriteDto> getFavorites() {
        return favoriteService.findAll();
    }

    @GetMapping("/{id}")
    public FavoriteDto getFavorite(@PathVariable("id") Long id) {
        return favoriteService.findByPropertyId(id);
    }

    @PostMapping()
    public void save(@RequestBody FavoriteDto favoriteDto) {
        favoriteService.save(favoriteDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        favoriteService.deleteById(id);
    }
}

