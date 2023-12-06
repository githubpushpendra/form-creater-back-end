package com.fc.formcreater.service;

import com.fc.formcreater.model.*;
import com.fc.formcreater.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class FormService {

    @Autowired
    private FormRepository formRepository;
    @Autowired
    private QuestionService questionService;
    public List<Form> getAllForms() {
        return formRepository.findAll();
//        List<Form> forms = formRepository.findAll();
//        List<FormDTO> formDTOs = new ArrayList<>();
//        for(Form form:forms){
//            FormDTO formDTO = new FormDTO(form.getId(), form.getTitle());
//            formDTOs.add(formDTO);
//        }
//        return formDTOs;
    }

    public Form getFormById(Long formId){
        return formRepository.findById(formId)
                .orElseThrow(()-> new IllegalArgumentException("Form with Id: " + formId + " not found"));
    }

    public Long saveForm(Form form) {
        // Save the form
        Form savedForm = formRepository.save(form);

        // Iterate through questions and associate them with the form
        if(savedForm.getQuestions().size() > 0){
            for (Question question : form.getQuestions()) {
                question.setForm(savedForm);
                questionService.saveQuestion(question);
            }
        }

        return savedForm.getId();
    }

    // other methods as needed
}

