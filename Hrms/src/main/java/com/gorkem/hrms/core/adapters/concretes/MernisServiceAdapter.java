package com.gorkem.hrms.core.adapters.concretes;

import MernisService.EKOKPSPublicSoap;
import com.gorkem.hrms.core.adapters.abstracts.MicroService;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;

public class MernisServiceAdapter implements MicroService {

    private final static EKOKPSPublicSoap ekokpsPublicSoap = new EKOKPSPublicSoap();

    public  boolean validation(IndividualUserRegisterDto individualUserRegisterDto) {

        try{
            return ekokpsPublicSoap.TCKimlikNoDogrula(
                    Long.parseLong(individualUserRegisterDto.getIdentityNumber()),

                    individualUserRegisterDto.getFirstName(),

                    individualUserRegisterDto.getLastName(),

                    individualUserRegisterDto.getDateOfBirth().getYear());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
