package com.fc.formcreater.controller;


import com.fc.formcreater.model.Form;
import com.fc.formcreater.service.FormService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/forms")
@CrossOrigin(origins = "http://localhost:3000")
public class FormController {

    private FormService formService;

    @Autowired
    public FormController(FormService formService){
        this.formService = formService;
    }

    @GetMapping("/test")
    public String testAPI(){
        return "welcome to form-builder application";
    }

    @GetMapping("/")
    public List<Form> getAllForms() {
        return formService.getAllForms();
    }

    @GetMapping("/{formId}")
    public Form getFormById(@PathVariable Long formId){
        return formService.getFormById(formId);
    }

    @PostMapping("/")
    public Long createForm(@RequestBody Form form) {
        System.out.println("Form received");
        return formService.saveForm(form);
    }

    // other methods for updating and deleting forms
}
