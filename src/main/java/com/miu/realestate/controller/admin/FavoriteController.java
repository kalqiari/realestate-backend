package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.response.FavoriteDto;
import com.miu.realestate.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @GetMapping("/v1/favorites")
    public List<FavoriteDto> getFavorites() {
        return favoriteService.findAll();
    }

    @GetMapping("/v1/users/{id}")
    public FavoriteDto getFavorite(@PathVariable("id") Long id) {
        return favoriteService.findByPropertyId(id);
    }

    @PostMapping("/v1/users")
    public void save(@RequestBody FavoriteDto favoriteDto) {
        favoriteService.save(favoriteDto);
    }

    @DeleteMapping("/v1/users/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        favoriteService.deleteById(id);
    }
}
