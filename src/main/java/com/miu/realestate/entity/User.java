package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String streetAddress;
    private String address2;
    private String city;
    private String state;
    private String zipcode;

    private Date deactivate_at;
    private Date create_at;
    private Date deleted_at;


    @OneToMany
    List<Role> roles;

    @OneToMany(mappedBy = "landlord")
    List<Property> properties;

    @OneToMany
    List<Application> applications;

    @ManyToMany
    List<Favorite> favoriteList;

    @OneToMany
    List<Question> Question;

}
