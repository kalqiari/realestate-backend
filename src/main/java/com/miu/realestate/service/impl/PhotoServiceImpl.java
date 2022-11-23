package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.Photo;
import com.miu.realestate.repo.PhotoRepo;
import com.miu.realestate.service.PhotoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoServiceImpl implements PhotoService {

    private PhotoRepo photoRepo;

    @Autowired
    public PhotoServiceImpl(PhotoRepo photoRepo){
        this.photoRepo = photoRepo;
    }

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<Photo> findAll() {

        var photos = photoRepo.findAll();

        return photos
                .stream()
                .map(photo -> modelMapper.map(photo, Photo.class))
                .collect(Collectors.toList());
    }

    @Override
    public Photo findById(Long id) {
        return modelMapper.map(photoRepo.findById(id), Photo.class);
    }

    @Override
    public void deleteById(Long id) {
        photoRepo.deleteById(id);
    }

    @Override
    public void save( List<MultipartFile> files) {
//        if(files.size() > 0){
//            var photoMetas = s3BucketStorageService.uploadFiles(RandomAlphabet.random(user.getId().toString()),files);
//            var photos = photoMetas.stream().map(meta -> new Photo(meta.getUrl(),meta.getKeyName())).toList();
//            property.addPhotos(photos);
//        }
//        property.setAvailable(Boolean.TRUE);
//        property = propertyRepository.save(property);
//        return modelMapper.map(property,PropertyDto.class);
    }
}
