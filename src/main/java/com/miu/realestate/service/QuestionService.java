package com.miu.realestate.service;

import com.miu.realestate.entity.dto.response.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> findAll();

    QuestionDto findById(Long id);

    void deleteById(Long id);

    void save(QuestionDto questionDto);

}
