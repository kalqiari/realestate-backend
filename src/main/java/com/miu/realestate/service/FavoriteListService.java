package com.miu.realestate.service;

import com.miu.realestate.entity.FavoriteList;
import com.miu.realestate.entity.dto.response.FavoriteListDto;

import java.util.List;

public interface FavoriteListService {
    List<FavoriteListDto> findByUserId(Long id);

    void save(FavoriteListDto list);
}
