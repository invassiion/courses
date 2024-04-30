package com.example.courses.courses.dto;

import com.example.courses.courses.model.CourseEntity;
import com.example.courses.student.dto.StudentResponseDTO;
import com.example.courses.student.model.StudentEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CourseResponseDTO {
    protected Long id;
    protected String title;
    protected String description;

    public static CourseResponseDTO of(CourseEntity entity) {
        return CourseResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }
}
