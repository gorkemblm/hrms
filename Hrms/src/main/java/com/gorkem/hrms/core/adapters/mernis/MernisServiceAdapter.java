package com.gorkem.hrms.core.adapters.mernis;

import com.gorkem.hrms.MernisService.INLKPSPublicSoap;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MernisServiceAdapter implements AuthenticationService {

    public static final INLKPSPublicSoap kpsPublicSoap = new INLKPSPublicSoap();

    public boolean isRealPerson(IndividualUser individualUser) {

        try {
            return kpsPublicSoap.TCKimlikNoDogrula(Long.parseLong(individualUser.getIdentityNumber())
                    ,individualUser.getFirstName().toUpperCase(new Locale("tr,","TR"))
                    ,individualUser.getLastName().toLowerCase(new Locale("tr","TR"))
                    ,individualUser.getDateOfBirth().getYear());

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
