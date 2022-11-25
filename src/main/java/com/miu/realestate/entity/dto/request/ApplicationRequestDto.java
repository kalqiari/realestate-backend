package com.miu.realestate.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDto {

    private Long Id;
    private long propertyId;
    private long userId;
    private String applicationType;
    private String employmentInfo;
    private double creditScore;
    private String reviewStatus;
    private String message;
    private LocalDate droppedAt;
    private LocalDate createdAt;
    private LocalDate reviewedAt;
    private LocalDate deletedAt;
}
