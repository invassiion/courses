package com.example.courses.service;

import com.example.courses.dto.CoursesDTO.CourseRequestDTO;
import com.example.courses.dto.CoursesDTO.CourseResponseDTO;
import com.example.courses.model.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

public CourseResponseDTO createCourse(CourseRequestDTO requestDTO) {
    return  null;
}
    public void updateCourse(Long id, CourseRequestDTO requestDTO) {
        // Поиск курса по ID
        // Обновление данных курса
        // Сохранение изменений в базу данных
    }

    public CourseResponseDTO getCourseById(Long id) {
        // Поиск курса по ID
        // Преобразование сущности в DTO
        // Возврат DTO
        return  null;
    }

    public List<CourseResponseDTO> searchCoursesByTitle(String title) {
        // Поиск курсов по названию
        // Преобразование списка сущностей в список DTO
        // Возврат списка DTO
        return  null;
    }

    public void deleteCourse(Long id) {
        // Поиск курса по ID
        // Удаление курса из базы данных
    }
}
