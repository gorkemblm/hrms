package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.entities.concretes.CorporateUser;
import com.gorkem.hrms.entities.concretes.dtos.CorporateUserRegisterDto;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface CorporateUserService {

    List<CorporateUser> getAll();

    CorporateUser save(CorporateUserRegisterDto corporateUserRegisterDto) throws NoSuchAlgorithmException;
}

