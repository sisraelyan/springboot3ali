package com.samvel.uexample.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "Firstname should not be empty")
        String firstname,
        @NotEmpty(message = "Lastname should not be empty")
        String lastname,
        @Email(message = "Provided email does not look like a valid email address")
        String email,
        Integer schoolId
) {
}
