package com.example.courses.lesson.dto;

import com.example.courses.courses.dto.CourseResponseDTO;
import com.example.courses.courses.model.CourseEntity;
import com.example.courses.lesson.model.LessonEntity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LessonResponseDTO {
    private Long id;

    protected String title;

    protected String description;

    protected Long courseId;

    public static LessonResponseDTO of(LessonEntity entity) {
        return LessonResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .courseId(entity.getCourseId())
                .build();
    }
}
