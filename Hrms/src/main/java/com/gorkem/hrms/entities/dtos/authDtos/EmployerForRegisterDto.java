package com.gorkem.hrms.entities.dtos.authDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {

    @NotBlank(message = "Email value cannot be empty")
    @Email(message = "The value you enter must be in email format")
    private String email;

    @NotBlank(message = "Password value cannot be empty")
    @Size(max = 16, message = "Your password cannot be longer than 16 characters")
    private String password;

    @NotBlank(message = "Company Name value cannot be empty")
    @Size(max = 256, message = "Company name cannot exceed 255 characters")
    private String companyName;

    @NotBlank(message = "Website value cannot be empty")
    @Size(max = 256, message = "Website name cannot exceed 255 characters")
    private String webSite;

    @NotBlank(message = "Phone number value cannot be empty")
    @Size(min = 10, max = 13, message = "Phone number must be a minimum of 10 characters and a maximum of 13 characters")
    private String phoneNumber;
}
