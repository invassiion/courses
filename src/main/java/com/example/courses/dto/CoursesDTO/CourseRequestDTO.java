package com.example.courses.dto.CoursesDTO;

import ch.qos.logback.core.sift.AppenderTracker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class CourseRequestDTO {
    protected String title;
    protected String description;
}
