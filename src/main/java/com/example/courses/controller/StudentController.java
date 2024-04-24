package com.example.courses.controller;

import com.example.courses.dto.studentDTO.EditStudentRequestDTO;
import com.example.courses.dto.studentDTO.RegistrationStudentRequest;
import com.example.courses.dto.studentDTO.StudentResponseDTO;
import com.example.courses.routes.StudentRoutes;
import com.example.courses.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @PostMapping(StudentRoutes.REGISTRATION)
    public ResponseEntity<StudentResponseDTO> registerStudent(@RequestBody RegistrationStudentRequest request) {
        StudentResponseDTO responseDTO = studentService.registerStudent(request);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(StudentRoutes.UPDATE)
    public ResponseEntity<Void> updateStudent(@RequestBody EditStudentRequestDTO requestDTO) {
        studentService.updateStudent(requestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping(StudentRoutes.BY_ID)
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        StudentResponseDTO responseDTO = studentService.getStudentById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(StudentRoutes.SEARCH)
    public ResponseEntity<List<StudentResponseDTO>> searchStudents(@RequestParam String name) {
        List<StudentResponseDTO> responseDTOS = studentService.searchStudentsByName(name);
        return  ResponseEntity.ok(responseDTOS);
    }

}
