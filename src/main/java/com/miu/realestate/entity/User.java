package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String streetAddress;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private boolean status;
    private LocalDate deactivateAt;
    private LocalDate createdAt;
    private LocalDate deletedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    Role role;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Property> properties;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Application>  applications;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Favorite> favorites;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Question> questions;


}
