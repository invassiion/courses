package com.example.courses.student.service;

import com.example.courses.base.service.CustomUserDetailsService;
import com.example.courses.student.dto.EditStudentRequestDTO;
import com.example.courses.student.dto.RegistrationStudentRequest;
import com.example.courses.student.dto.StudentResponseDTO;
import com.example.courses.base.exception.BadRequestException;
import com.example.courses.student.exception.StudentAlreadyExistException;
import com.example.courses.student.exception.StudentNotFoundException;
import com.example.courses.student.model.StudentEntity;
import com.example.courses.student.model.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public StudentResponseDTO registerStudent(RegistrationStudentRequest request) throws BadRequestException, StudentAlreadyExistException {
        request.validate();

        Optional<StudentEntity> check = studentRepository.findByEmail(request.getEmail());
        if (check.isPresent()) throw  new StudentAlreadyExistException();

        StudentEntity student = StudentEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        student = studentRepository.save(student);
        return StudentResponseDTO.of(student);
    }

    public StudentResponseDTO updateStudent(Principal principal, EditStudentRequestDTO requestDTO) throws StudentNotFoundException {
    StudentEntity student = studentRepository.findByEmail(principal.getName())
            .orElseThrow(StudentNotFoundException::new);
    student.setFirstName(requestDTO.getFirstName());
    student.setLastName(requestDTO.getLastName());

    student = studentRepository.save(student);
    return StudentResponseDTO.of(student);
    }


    public StudentResponseDTO getStudentById(Long id) {
      return StudentResponseDTO.of(studentRepository.findById(id).orElseThrow(StudentNotFoundException::new));

    }

    public List<StudentResponseDTO> searchStudentsByName(String name) {
        List<StudentEntity> students = studentRepository.findByFirstNameContainingIgnoreCase(name);
        return students.stream()
                .map(StudentResponseDTO::of)
                .collect(Collectors.toList());
    }


}
