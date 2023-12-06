package com.fc.formcreater.controller;

import com.fc.formcreater.dto.QuestionDTO;
import com.fc.formcreater.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.fc.formcreater.model.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/form/{formId}")
    public List<QuestionDTO> getAllQuestionsByFormId(@PathVariable Long formId) {
        return questionService.getAllQuestionsByFormId(formId);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    // other methods for updating and deleting questions
}