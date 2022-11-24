package com.miu.realestate.entity.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miu.realestate.entity.Photo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PropertyDto {
    private Long id;
    private Long userId;
    private String streetAddress;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String propertyStatus;
    private String listing_type;
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
    private Date yearBuilt;
    private boolean isBuiltComplete;
    private Date listedAt;
    private Date deletedAt;
    private String status;
    private List<PhotoDto> photos;
}
