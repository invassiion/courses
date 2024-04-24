package com.example.courses.dto.studentDTO;

import com.example.courses.exception.BadRequestException;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegistrationStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public void validate() throws BadRequestException {
        if (email == null || email.isBlank()) throw new BadRequestException();
        if (password == null || password.isBlank()) throw new BadRequestException();
    }
}
