package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.response.PhotoDto;
import com.miu.realestate.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/v1/photos")
    public List<PhotoDto> getPhotos() {
        return photoService.findAll();
    }

    @GetMapping("/v1/photos/{id}")
    public PhotoDto getPhoto(@PathVariable("id") Long id) {
        return photoService.findById(id);
    }

    @PostMapping("/v1/photos")
    public void save(@RequestBody PhotoDto photoDto) {
        photoService.save(photoDto);
    }

    @DeleteMapping("/v1/photos/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        photoService.deleteById(id);
    }

}
