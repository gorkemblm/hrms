package com.gorkem.hrms.core.adapters.abstracts;

import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public interface MicroService {

    public boolean validation(IndividualUserRegisterDto individualUserRegisterDto) throws Exception;
}
