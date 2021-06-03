package com.gorkem.hrms.entities.dtos.authDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForRegisterDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private LocalDate dateOfBirth;
}
