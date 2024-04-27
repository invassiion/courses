package com.example.courses.student.dto;

import com.example.courses.student.model.StudentEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class StudentResponseDTO {
 private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static StudentResponseDTO of(StudentEntity entity) {
        return StudentResponseDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }
}
