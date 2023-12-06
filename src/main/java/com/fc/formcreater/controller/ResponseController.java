package com.fc.formcreater.controller;

import com.fc.formcreater.dto.ResponseDTO;
import com.fc.formcreater.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.fc.formcreater.model.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/responses")
@CrossOrigin(origins = "http://localhost:3000")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/question/{questionId}")
    public List<ResponseDTO> getAllResponsesByQuestionId(@PathVariable Long questionId) {
        return responseService.getAllResponsesByQuestionId(questionId);
    }

    @PostMapping
    public ResponseEntity<String> createResponse(@RequestBody List<Response> responses) {
        System.out.println(responses);
        for(Response response:responses){
            System.out.println(response);
            responseService.saveResponse(response);
        }
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    // other methods for updating and deleting responses
}