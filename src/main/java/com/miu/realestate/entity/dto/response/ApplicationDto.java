package com.miu.realestate.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

    private Long Id;
    private long propertyId;
    private String applicationType;
    private String employmentInfo;
    private double creditScore;
    private String reviewStatus;
    private String message;
    private LocalDate droppedAt;
    private LocalDate createdAt;
    private LocalDate reviewedAt;
    private LocalDate deletedAt;
    private PropertyDto property;
    private UserDto user;

}
