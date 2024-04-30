package com.example.courses.lesson.dto;

import com.example.courses.lesson.model.LessonEntity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LessonRequestDTO {
    protected String title;
    protected String description;
    protected Long courseId;

    public LessonEntity entity(){
        return LessonEntity.builder()
                .title(title)
                .description(description)
                .courseId(courseId)
                .build();
    }
}
