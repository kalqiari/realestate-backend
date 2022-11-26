package com.miu.realestate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@NoArgsConstructor
@Data
public class Email {
       private String to;
       private String from;
       private String subject;
       private String content;
       private String template;
       Map<String, Object> variables;
}
