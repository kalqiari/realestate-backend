package com.miu.realestate.repo;

import com.miu.realestate.entity.Favorite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepo extends CrudRepository<Favorite, Long> {
    List<Favorite> findAll();

    List<Favorite> findByPropertyIdAndUserId(Long id, Long user_id);


//    @Query("delete from Favorite f where f.property.id = :propertyId  and f.user.id = :userID")
    void deleteByPropertyIdAndUserId(Long propertyId, Long userID);
}
