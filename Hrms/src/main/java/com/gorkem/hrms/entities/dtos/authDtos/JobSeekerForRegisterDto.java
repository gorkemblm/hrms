package com.gorkem.hrms.entities.dtos.authDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForRegisterDto {

    @NotBlank(message = "Email value cannot be empty")
    @Email(message = "The value you enter must be in email format")
    private String email;

    @NotBlank(message = "Password value cannot be empty")
    @Size(max = 16, message = "Your password cannot be longer than 16 characters")
    private String password;

    @NotBlank(message = "First name value cannot be empty")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name value cannot be empty")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Identity number value cannot be empty")
    @Size(message = "Identity number must consist of 11 characters")
    private String identityNumber;

    @NotNull(message = "Date of birth value cannot be empty")
    @Past
    private LocalDate dateOfBirth;
}
