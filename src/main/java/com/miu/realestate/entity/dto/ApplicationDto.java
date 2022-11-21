package com.miu.realestate.entity.dto;

import com.miu.realestate.entity.ApplicationType;
import com.miu.realestate.entity.ReviewStatus;

import java.util.Date;

public class ApplicationDto {
    private Long application_id;
    private Long property_id;
    private Long user_id;
    private ApplicationType application_type;
    private String employment_info;
    private double credit_score;
    private ReviewStatus review_Status;
    private Date dropped_at;
    private Date created_at;
    private Date reviewed_at;
    private Date deleted_at;
}
