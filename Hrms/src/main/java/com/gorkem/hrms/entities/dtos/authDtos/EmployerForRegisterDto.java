package com.gorkem.hrms.entities.dtos.authDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {

    private String email;
    private String password;
    private String companyName;
    private String webSite;
    private String phoneNumber;
}
