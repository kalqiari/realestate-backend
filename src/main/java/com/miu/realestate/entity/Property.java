package com.miu.realestate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String streetAddress;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String listingType;
    private String description;
    private double price;
    private String homeType;
    private double sqFt;
    private int bedrooms;
    private double bathrooms;
    private boolean pool;
    private String parkingType;
    private int parkingSpaces;
    private String floorType;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date yearBuilt;

    private boolean isBuiltComplete;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date listedAt;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date deletedAt;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "property")
    List<Photo> photos;

    @ManyToMany(mappedBy = "properties")
    List<Favorite> favoriteList;

    @OneToMany(mappedBy = "property")
    List<Question> questions;


    @ManyToOne
    private User landlord;


    @OneToMany
    List<Photo> photos;


    @ManyToMany
    List<Favorite> favoriteList;

    @OneToMany
    List<Question> question;

}
