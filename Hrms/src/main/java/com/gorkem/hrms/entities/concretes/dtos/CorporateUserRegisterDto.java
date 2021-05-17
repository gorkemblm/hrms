package com.gorkem.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateUserRegisterDto extends UserRegisterDto {

    private String companyName;
    private String webSite;

}
