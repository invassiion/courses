package com.example.courses.dto.studentDTO;

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
