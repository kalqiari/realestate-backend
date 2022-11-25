package com.miu.realestate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private String propertyStatus;
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
    private String status;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date yearBuilt;

    private boolean isBuiltComplete;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date listedAt;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date deletedAt;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date soldRentedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="property_id")
    List<Photo> photos;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    List<Favorite> favorites;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    List<Question> questions;

}
