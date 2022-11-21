package com.miu.realestate.controller.admin;

import com.miu.realestate.entity.dto.response.QuestionDto;
import com.miu.realestate.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("api"))
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/v1/questions")
    public List<QuestionDto> getQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/v1/questions/{id}")
    public QuestionDto getQuestion(@PathVariable("id") Long id) {
        return questionService.findById(id);
    }

    @PostMapping("/v1/questions")
    public void save(@RequestBody QuestionDto questionDto) {
        questionService.save(questionDto);
    }

    @DeleteMapping("/v1/questions/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        questionService.deleteById(id);
    }
}
