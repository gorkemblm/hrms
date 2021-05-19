package com.gorkem.hrms.core.adapters.abstracts;

import com.gorkem.hrms.entities.concretes.IndividualUser;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;

public interface MicroService {

    public boolean validation(IndividualUserRegisterDto individualUserRegisterDto);
}
