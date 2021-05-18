package com.gorkem.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualUserRegisterDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private LocalDate dateOfBirth;
    private char gender;

}
