package com.gorkem.hrms.core.adapters.mernis;

import com.gorkem.hrms.MernisService.INLKPSPublicSoap;
import com.gorkem.hrms.business.abstracts.UserCheckService;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MernisServiceAdapter implements UserCheckService {

    public INLKPSPublicSoap kpsPublicSoap = new INLKPSPublicSoap();

    @Override
    public boolean checkIfRealPerson(IndividualUser individualUser) {
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
