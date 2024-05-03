package com.example.courses.student.controller;

import com.example.courses.student.dto.EditStudentRequestDTO;
import com.example.courses.student.dto.RegistrationStudentRequest;
import com.example.courses.student.dto.StudentResponseDTO;
import com.example.courses.base.exception.BadRequestException;
import com.example.courses.student.exception.StudentAlreadyExistException;
import com.example.courses.student.routes.StudentRoutes;
import com.example.courses.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;


    @GetMapping(StudentRoutes.INIT)
    public ResponseEntity<StudentResponseDTO> init() {
        StudentResponseDTO responseDTO = studentService.initStudent();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Регистрация студента")
    @PostMapping(StudentRoutes.REGISTRATION)
    public ResponseEntity<StudentResponseDTO> registerStudent(@RequestBody RegistrationStudentRequest request) throws StudentAlreadyExistException, BadRequestException {
        StudentResponseDTO responseDTO = studentService.registerStudent(request);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @Operation(summary = "Изменение данных студента")
    @PutMapping(StudentRoutes.UPDATE)
    public ResponseEntity<StudentResponseDTO> updateStudent(Principal principal, @RequestBody EditStudentRequestDTO requestDTO) {
        studentService.updateStudent(principal,requestDTO);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "поиск студента по Id")
    @GetMapping(StudentRoutes.BY_ID)
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        StudentResponseDTO responseDTO = studentService.getStudentById(id);
        return ResponseEntity.ok(responseDTO);
    }


    @Operation(summary = "Поиск студентов по имени")
    @GetMapping(StudentRoutes.SEARCH)
    public ResponseEntity<List<StudentResponseDTO>> searchStudents(@RequestParam String name) {
        List<StudentResponseDTO> responseDTOS = studentService.searchStudentsByName(name);
        return  ResponseEntity.ok(responseDTOS);
    }

}
