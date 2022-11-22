package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.response.PhotoDto;
import com.miu.realestate.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/photos")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/")
    public List<PhotoDto> getPhotos() {
        return photoService.findAll();
    }

    @GetMapping("/{id}")
    public PhotoDto getPhoto(@PathVariable("id") Long id) {
        return photoService.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody PhotoDto photoDto) {
        photoService.save(photoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        photoService.deleteById(id);
    }

}
