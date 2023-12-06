package com.fc.formcreater.service;


import com.fc.formcreater.dto.ResponseDTO;
import com.fc.formcreater.repository.QuestionRepository;
import com.fc.formcreater.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.formcreater.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private QuestionRepository questionRepository;


    public List<ResponseDTO> getAllResponsesByQuestionId(Long questionId) {
        List<Response> responses = responseRepository.findAllByQuestionId(questionId);
        List<ResponseDTO> responseDTOs = new ArrayList<>();
        for(Response response:responses){
            ResponseDTO responseDTO = new ResponseDTO(response.getId(), response.getAnswer());
            responseDTOs.add(responseDTO);
        }
        return responseDTOs;
    }

    public Response saveResponse(Response response) {
        System.out.println("At service class response is::  ");
        System.out.println(response);
        return responseRepository.save(response);
    }

    // other methods as needed

//    public Response saveResponse(Response response) {
//        // Assuming that the response object contains the questionId field
//        Long questionId = response.getQuestion().getId();
//
//        // Check if the question exists
////        if (!questionRepository.existsById(questionId)) {
////            throw new IllegalArgumentException("Question with ID " + questionId + " not found.");
////        }
//
//        // Set the association between response and question
//        response.setQuestion(questionRepository.findById(questionId)
//                .orElseThrow(()->new IllegalArgumentException("Question with ID " + questionId + " not found."))
//        );
//
//        // Save the response
//        return responseRepository.save(response);
//    }
}