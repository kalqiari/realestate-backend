package com.miu.realestate.service.Impl;

import com.miu.realestate.entity.Question;
import com.miu.realestate.entity.dto.response.QuestionDto;
import com.miu.realestate.repo.QuestionRepo;
import com.miu.realestate.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepo questionRepo;

    @Autowired
    public QuestionServiceImpl(QuestionRepo questionRepo){
        this.questionRepo =questionRepo;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<QuestionDto> findAll() {

        var questions = questionRepo.findAll();
        return questions
                .stream()
                .map(question -> modelMapper.map(question, QuestionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto findById(Long id) {
        return modelMapper.map(questionRepo.findById(id), QuestionDto.class);
    }

    @Override
    public void deleteById(Long id) {

        questionRepo.deleteById(id);

    }

    @Override
    public void save(QuestionDto questionDto) {
        questionRepo.save(modelMapper.map(questionDto, Question.class));
    }
}
