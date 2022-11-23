package com.miu.realestate.service;

import com.miu.realestate.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    List<Photo> findAll();

    Photo findById(Long id);

    void deleteById(Long id);

    void save(List<MultipartFile> files);


}
