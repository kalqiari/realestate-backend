package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.Favorite;
import com.miu.realestate.entity.dto.response.FavoriteDto;
import com.miu.realestate.repo.FavoriteRepo;
import com.miu.realestate.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteRepo favoriteRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<FavoriteDto> findAll() {
        List<Favorite> favorite = favoriteRepo.findAll();
        return favorite
                .stream()
                .map(fav -> modelMapper.map(fav, FavoriteDto.class) )
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteDto findByPropertyId(Long id) {
        return modelMapper.map(favoriteRepo.findById(id), FavoriteDto.class);
    }

    @Override
    public void save(FavoriteDto favoriteDto) {
        favoriteRepo.save(modelMapper.map(favoriteDto, Favorite.class));
    }

    @Override
    public void deleteById(Long id) {
        favoriteRepo.deleteById(id);
    }
}
