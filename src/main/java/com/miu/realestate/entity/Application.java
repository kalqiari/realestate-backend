package com.miu.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
