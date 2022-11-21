package com.miu.realestate.entity;

import java.util.Date;

public class User {

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
