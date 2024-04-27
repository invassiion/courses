package com.example.courses.lesson.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LessonResponseDTO {
    private Long id;

    protected String title;

    protected String description;

    protected Long courseId;
}
