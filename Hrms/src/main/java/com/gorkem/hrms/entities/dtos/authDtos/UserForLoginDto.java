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
public class UserForLoginDto {

    @NotBlank(message = "Email value cannot be empty")
    @Email(message = "The value you enter must be in email format")
    private String email;

    @NotBlank(message = "Password value cannot be empty")
    @Size(max = 16, message = "Your password cannot be longer than 16 characters")
    private String password;
}
