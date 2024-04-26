package com.example.courses.dto.CoursesDTO;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CourseResponseDTO {
    protected Long id;
    protected String title;
    protected String description;
}
