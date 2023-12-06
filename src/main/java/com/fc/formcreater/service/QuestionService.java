package com.fc.formcreater.service;


import com.fc.formcreater.dto.QuestionDTO;
import com.fc.formcreater.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.formcreater.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    public List<QuestionDTO> getAllQuestionsByFormId(Long formId) {
        List<Question> questions = questionRepository.findAllByFormId(formId);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for(Question question : questions){
            QuestionDTO questionDTO = new QuestionDTO(question.getId(), question.getText());
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    // other methods as needed
}