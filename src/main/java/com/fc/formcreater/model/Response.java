package com.fc.formcreater.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // getters and setters
}
