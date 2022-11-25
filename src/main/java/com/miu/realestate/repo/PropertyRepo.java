package com.miu.realestate.repo;

import com.miu.realestate.entity.Property;
import com.miu.realestate.entity.dto.response.PropertyDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long> {

    List<Property> findAll();


    List<Property> findByBedrooms(int noOfRoom);

    List<Property> findByStateAndCity(String state, String city);

    List<Property> findByHomeType(String type);

    List <Property> findPropertyByPropertyStatus(String propertyStatus);

    List <Property> findPropertyByPrice(double price);

    List<Property> findPropertyByHomeType(String homeType);
    @Query("select p from Property p join Favorite f on p= f.property where f.user.id = :id ")
    List<Property> findPropertiesFavoriteByUserId(Long id);
   // @Query("select p from Property p join User u on p= u.properties where u.id = :id ")
    List<Property> findPropertyByUserId(Long id);

    @Query("select p from Property p inner join Application a on p=a.property where p.deletedAt='0-0-0' and p.soldRentedAt< :nowPlus10 and  p.soldRentedAt>=:now")
    List<Property> findAllRentedByDateRange(LocalDate now, LocalDate nowPlus10 );
}
