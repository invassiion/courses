package com.example.courses.lesson.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LessonRequestDTO {
    protected String title;
    protected String description;
    protected Long courseId;
}
