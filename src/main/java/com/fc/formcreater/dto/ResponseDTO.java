package com.fc.formcreater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ResponseDTO {
    private Long id;
    private String answer;

    public ResponseDTO(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    // Getters and setters
}
