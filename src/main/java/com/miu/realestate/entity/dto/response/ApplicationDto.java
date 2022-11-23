package com.miu.realestate.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

    private Long applicationId;
    private String applicationType;
    private String employmentInfo;
    private double creditScore;
    private String reviewStatus;
    private Date droppedAt;
    private Date createdAt;
    private Date reviewedAt;
    private Date deletedAt;

}
