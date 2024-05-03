package com.example.courses.base.service;

import com.example.courses.student.model.StudentEntity;
import com.example.courses.student.model.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findByEmail(email);
        if (studentEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException("Student with email not found:" + email);
        }

        StudentEntity studentEntity = studentEntityOptional.get();
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("user"));
        return new User(studentEntity.getEmail(), studentEntity.getPassword(), authorities);
    }
}
