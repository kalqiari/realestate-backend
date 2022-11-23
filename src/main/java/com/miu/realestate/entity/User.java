package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private boolean activeStatus;
    private LocalDate deactivate_at;
    private LocalDate create_at;
    private LocalDate deleted_at;

    @OneToMany
    List<Role> roles;

    @OneToMany(mappedBy = "owner")
    List<Property> properties;

    @OneToMany(mappedBy = "property")
    List<Application> customerApplications;

    @ManyToMany(mappedBy = "users")
    List<Favorite> favoriteList;

    @OneToMany(mappedBy = "user")
    List<Question> customerQuestion;

}
