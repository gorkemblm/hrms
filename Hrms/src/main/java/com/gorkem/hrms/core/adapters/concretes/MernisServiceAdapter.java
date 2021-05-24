package com.gorkem.hrms.core.adapters.concretes;

import MernisService.EKOKPSPublicSoap;
import com.gorkem.hrms.core.adapters.abstracts.CheckService;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Qualifier("microservice")
public class MernisServiceAdapter implements CheckService {

    private final static EKOKPSPublicSoap ekokpsPublicSoap = new EKOKPSPublicSoap();

    public  boolean validation(IndividualUserRegisterDto individualUserRegisterDto) throws Exception {

        if (ekokpsPublicSoap.TCKimlikNoDogrula(
                Long.parseLong(individualUserRegisterDto.getIdentityNumber()),

                individualUserRegisterDto.getFirstName().toUpperCase(new Locale("tr","TR")),

                individualUserRegisterDto.getLastName().toUpperCase(new Locale("tr","TR")),

                individualUserRegisterDto.getDateOfBirth().getYear())){
            return true;
        }else {
            return false;
        }


    }
}
