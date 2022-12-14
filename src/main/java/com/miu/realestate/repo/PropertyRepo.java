package com.miu.realestate.repo;

import com.miu.realestate.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long> {

    List<Property> findAll();


    List<Property> findByBedrooms(int noOfRoom);

    List<Property> findByStateAndCity(String state, String city);

    List<Property> findByHomeType(String type);

    List <Property> findTop10ByPropertyStatusEqualsOrderBySoldRentedAt(String status);

    List <Property> findPropertyByPrice(double price);

    List<Property> findPropertyByHomeType(String homeType);
    @Query("select p from Property p join Favorite f on p= f.property where f.user.id = :id ")
    List<Property> findPropertiesFavoriteByUserId(Long id);
   // @Query("select p from Property p join User u on p= u.properties where u.id = :id ")
    List<Property> findPropertyByUserId(Long id);

    List<Property> findByCity(String input);

    List<Property> findByState(String input);


    List<Property> findByZipcode(String input);

    List<Property> findByPriceLessThan(double input);
}
