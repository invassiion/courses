package com.example.courses.dto.studentDTO;

import com.example.courses.model.entity.StudentEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class StudentResponseDTO {
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String email;

    public static StudentResponseDTO of(StudentEntity entity) {
        return StudentResponseDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }
}
