package com.example.courses.lesson.service;

import com.example.courses.lesson.dto.LessonRequestDTO;
import com.example.courses.lesson.dto.LessonResponseDTO;
import com.example.courses.lesson.model.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonResponseDTO createLesson(LessonRequestDTO requestDTO) {
//        Создание нового урока
//        Слхранение в  бд
//        Формирование и возврат DTO
        return null;
    }

    public void updateLesson(Long id, LessonRequestDTO requestDTO) {
        // Поиск урока по ID
        // Обновление данных урока
        // Сохранение изменений в базу данных
    }

    public LessonResponseDTO getLessonById(Long id) {
        // Поиск урока по ID
        // Преобразование сущности в DTO
        // Возврат DTO
        return null;
    }

    public List<LessonResponseDTO> searchLessonsByTitle(String title) {
        // Поиск уроков по названию
        // Преобразование списка сущностей в список DTO
        // Возврат списка DTO
        return null;
    }

    public void deleteLesson(Long id) {
        // Поиск урока по ID
        // Удаление урока из базы данных

    }
}
