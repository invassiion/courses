package com.example.courses.courses.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CourseRequestDTO {
    protected String title;
    protected String description;
}
