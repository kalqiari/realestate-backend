package com.miu.realestate.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String streetAddress;
    private String address2;
    private String city;
    private String state;
    private Integer zipcode;
}
