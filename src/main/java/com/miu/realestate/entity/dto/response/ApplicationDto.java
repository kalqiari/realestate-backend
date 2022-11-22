package com.miu.realestate.entity.dto.response;

import com.miu.realestate.entity.ApplicationType;
import com.miu.realestate.entity.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

    private Long applicationId;
    private Long propertyId;
    private Long userId;
    private ApplicationType applicationType;
    private String employmentInfo;
    private double creditScore;
    private ReviewStatus reviewStatus;
    private Date droppedAt;
    private Date createdAt;
    private Date reviewedAt;
    private Date deletedAt;

}
