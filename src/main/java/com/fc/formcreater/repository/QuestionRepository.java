package com.fc.formcreater.repository;

import com.fc.formcreater.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE q.form.id = :formId")
    List<Question> findAllByFormId(@Param("formId") Long formId);
}

