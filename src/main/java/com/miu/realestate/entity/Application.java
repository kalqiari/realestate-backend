package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
