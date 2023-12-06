package com.fc.formcreater.repository;



import com.fc.formcreater.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {

//    WHERE r.question.id = :questionId
    @Query("SELECT r FROM Response r WHERE r.question.id = :questionId")
    List<Response> findAllByQuestionId(@Param("questionId") Long questionId);
}