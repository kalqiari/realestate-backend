package com.miu.realestate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String streetAddress;
    private String address2;
    private String city;
    private String state;
    private Integer zipcode;

    private Date deactivate_at;
    private Date create_at;
    private Date deleted_at;

    private Integer role_id;

}
