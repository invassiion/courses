package com.example.courses.service;

import com.example.courses.dto.studentDTO.EditStudentRequestDTO;
import com.example.courses.dto.studentDTO.RegistrationStudentRequest;
import com.example.courses.dto.studentDTO.StudentResponseDTO;
import com.example.courses.model.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final CustomUserDetailsService customUserDetailsService;

    public StudentResponseDTO registerStudent(RegistrationStudentRequest request) {
        // Проверки на уникальность email и другие валидации
        // Создание нового студента
        // Хеширование пароля
        // Сохранение студента в базу данных
        // Формирование и возврат DTO
        return null;
    }

    public void updateStudent(EditStudentRequestDTO requestDTO) {
        // Поиск студента по ID
        // Обновление данных студента
        // Сохранение изменений в базу данных
    }
    public StudentResponseDTO getStudentById(Long id) {
        // Поиск студента по ID
        // Преобразование сущности в DTO
        // Возврат DTO
        return null;
    }

    public List<StudentResponseDTO> searchStudentsByName(String name) {
        // Поиск студентов по имени
        // Преобразование списка сущностей в список DTO
        // Возврат списка DTO
        return null;
    }
}
