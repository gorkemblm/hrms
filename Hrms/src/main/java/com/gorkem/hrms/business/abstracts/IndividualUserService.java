package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.entities.concretes.IndividualUser;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;

import java.util.List;

public interface IndividualUserService {

    List<IndividualUser> getAll();

    IndividualUser save(IndividualUserRegisterDto individualUserRegisterDto) throws Exception;

}
