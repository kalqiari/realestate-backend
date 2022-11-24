package com.miu.realestate.controller.owner;

import com.miu.realestate.entity.Photo;
import com.miu.realestate.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/v1/photos")
public class PhotoController {

    private PhotoService photoService;
    @Autowired
    public PhotoController(PhotoService photoService){
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getPhotos() {
        return photoService.findAll();
    }

    @GetMapping("/{id}")
    public Photo getPhoto(@PathVariable("id") Long id) {
        return photoService.findById(id);
    }

    @RolesAllowed("owner")
    @PostMapping("/")
    public void upload(@RequestPart("files") List<MultipartFile> files) throws Exception {
        photoService.save(files);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        photoService.deleteById(id);
    }

}
