package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.Photo;
import com.miu.realestate.entity.dto.response.PhotoDto;
import com.miu.realestate.repo.PhotoRepo;
import com.miu.realestate.service.PhotoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<PhotoDto> findAll() {

        var photos = photoRepo.findAll();

        return photos
                .stream()
                .map(photo -> modelMapper.map(photo, PhotoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PhotoDto findById(Long id) {
        return modelMapper.map(photoRepo.findById(id), PhotoDto.class);
    }

    @Override
    public void deleteById(Long id) {
        photoRepo.deleteById(id);
    }

    @Override
    public void save(PhotoDto photoDto) {
        photoRepo.save(modelMapper.map(photoDto, Photo.class));
    }
}
