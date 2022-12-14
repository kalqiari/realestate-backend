package com.miu.realestate.service;

import com.miu.realestate.entity.dto.response.FavoriteDto;

import java.util.List;

public interface FavoriteService {

    List<FavoriteDto> findAll();

    FavoriteDto findByPropertyId(Long id);

    void save(FavoriteDto favoriteDto);

    void deleteById(Long id);

    FavoriteDto findByPropertyIdAndUserId(Long id, Long user_id);

    void deleteByPropertyIdAndUserId(Long propertyId, Long userID);
}


