package com.miu.realestate.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    private String principal;
    private String operation;
    private String endPoint;
    private String method;
//    private LocalDateTime requestTime;
    @Column(columnDefinition = "TEXT")
    private String params;
}
