package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.response.QuestionDto;
import com.miu.realestate.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public List<QuestionDto> getQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestion(@PathVariable("id") Long id) {
        return questionService.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody QuestionDto questionDto) {
        questionService.save(questionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        questionService.deleteById(id);
    }
}
