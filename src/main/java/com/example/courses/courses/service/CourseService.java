package com.example.courses.courses.service;

import com.example.courses.courses.dto.CourseRequestDTO;
import com.example.courses.courses.dto.CourseResponseDTO;
import com.example.courses.courses.exception.CourseAlreadyExistException;
import com.example.courses.courses.exception.CourseNotFoundException;
import com.example.courses.courses.model.CourseEntity;
import com.example.courses.courses.model.CourseRepository;
import com.example.courses.lesson.model.LessonEntity;
import com.example.courses.lesson.model.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseService {
    private  final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {
    Optional<CourseEntity> check = courseRepository.findByTitle(requestDTO.getTitle());
    if (check.isPresent()) throw new CourseAlreadyExistException();

    CourseEntity course = CourseEntity.builder()
            .title(requestDTO.getTitle())
            .description(requestDTO.getDescription())
            .build();

    course = courseRepository.save(course);
    return CourseResponseDTO.of(course);
}


    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO requestDTO) {
        CourseEntity course = courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        course.setTitle(requestDTO.getTitle());
        course.setDescription(requestDTO.getDescription());

        course = courseRepository.save(course);
        return CourseResponseDTO.of(course);
    }

    public CourseResponseDTO getCourseById(Long id) {
        return CourseResponseDTO.of(courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new));
    }

    public List<CourseResponseDTO> searchCoursesByTitle(String title) {
        List<CourseEntity> courseEntities = courseRepository.findByTitleContainingIgnoreCase(title);

        return courseEntities.stream()
                .map(CourseResponseDTO::of)
                .collect(Collectors.toList());
    }

    public String deleteCourse(Long id) {
        List<LessonEntity> lessons = lessonRepository.findByCourseId(id);
        for (LessonEntity lesson : lessons) lessonRepository.deleteById(lesson.getId());

        courseRepository.deleteById(id);
        return HttpStatus.OK.name();
    }

    public List<CourseResponseDTO> search(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("title",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("description",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<CourseEntity> example = Example.of(
                CourseEntity.builder()
                        .title(query)
                        .title(query)
                        .build(), ignoringExampleMatcher);
        return courseRepository
                .findAll(example, pageable)
                .stream()
                .map(CourseResponseDTO::of)
                .collect(Collectors.toList());
    }
}
