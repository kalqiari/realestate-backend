package com.miu.realestate.service;

import com.miu.realestate.entity.Photo;
import com.miu.realestate.entity.dto.response.PhotoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    List<PhotoDto> findAll();

    PhotoDto findById(Long id);

    void deleteById(Long id);

    void save(List<MultipartFile> files);


}
