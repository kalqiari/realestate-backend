package com.miu.realestate.service.impl;

import com.miu.realestate.entity.FavoriteList;
import com.miu.realestate.entity.dto.response.FavoriteListDto;
import com.miu.realestate.repo.FavoriteListRepo;
import com.miu.realestate.service.FavoriteListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteListServiceImpl implements FavoriteListService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FavoriteListRepo favoriteListRepo;

    @Override
    public List<FavoriteListDto> findByUserId(Long id) {
        var list = favoriteListRepo.findByUserId(id);
        return list
                .stream()
                .map(l -> modelMapper.map(l, FavoriteListDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(FavoriteListDto favoriteListDto) {
        favoriteListRepo.save(modelMapper.map(favoriteListDto, FavoriteList.class));
    }
}
