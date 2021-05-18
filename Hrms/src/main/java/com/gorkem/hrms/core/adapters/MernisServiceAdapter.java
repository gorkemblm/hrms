package com.gorkem.hrms.core.adapters;

import MernisService.EKOKPSPublicSoap;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;

public class MernisServiceAdapter {

    private final static EKOKPSPublicSoap ekokpsPublicSoap = new EKOKPSPublicSoap();

    public static boolean mernisServiceValidation(IndividualUserRegisterDto individualUserRegisterDto) throws Exception {

        final boolean result = ekokpsPublicSoap.TCKimlikNoDogrula(
                Long.parseLong(individualUserRegisterDto.getIdentityNumber()),

                individualUserRegisterDto.getFirstName(),

                individualUserRegisterDto.getLastName(),

                individualUserRegisterDto.getDateOfBirth().getYear());

        if (result) {
            return true;
        } else {
            return false;
        }

    }
}
