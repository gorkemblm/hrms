package com.gorkem.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateUserRegisterDto {

    private String email;
    private String password;
    private String companyName;
    private String webSite;

}
