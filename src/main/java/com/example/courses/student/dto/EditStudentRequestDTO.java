package com.example.courses.student.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EditStudentRequestDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
