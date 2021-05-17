package com.gorkem.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualUserRegisterDto extends UserRegisterDto {

    private String firstName;
    private String lastName;
    private String identityNumber;
    private char gender;
    private LocalDate dateOfBirth;
}
