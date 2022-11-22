package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Long owner_id;
    private String street_address;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String listing_type;
    private String description;
    private double price;
    private String home_type;
    private double sqFt;
    private int bedrooms;
    private double bathrooms;
    private boolean pool;
    private String parking_type;
    private int parking_spaces;
    private String floorType;
    private Date year_built;
    private boolean is_built_complete;
    private Date listed_at;
    private Date deleted_at;


    @ManyToOne
    private User landlord;


    @OneToMany
    List<Photo> photos;


    @ManyToMany
    List<Favorite> favoriteList;

    @OneToMany
    List<Question> questions;

}
