package com.miu.realestate.repo;

import com.miu.realestate.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
}
