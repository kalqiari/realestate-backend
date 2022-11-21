package com.miu.realestate.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long userId;
    private Long propertyId;
    private String content;
    private Date createdAt;
}
