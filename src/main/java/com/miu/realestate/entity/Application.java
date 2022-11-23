package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    private String applicationType;
    private String employmentInfo;
    private double creditScore;
    private String reviewStatus;
    private LocalDate droppedAt;
    private LocalDate createdAt;
    private LocalDate reviewedAt;
    private LocalDate deletedAt;

    @ManyToOne
    User user;

    @ManyToOne
    Property property;

}
