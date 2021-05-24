package com.gorkem.hrms.core.adapters.abstracts;

import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;



public interface CheckService {

    boolean validation(IndividualUserRegisterDto individualUserRegisterDto) throws Exception;
}
