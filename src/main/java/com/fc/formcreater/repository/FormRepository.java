package com.fc.formcreater.repository;

import com.fc.formcreater.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}