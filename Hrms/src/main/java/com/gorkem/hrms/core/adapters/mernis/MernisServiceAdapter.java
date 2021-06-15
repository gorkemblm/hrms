package com.gorkem.hrms.core.adapters.mernis;

import com.gorkem.hrms.core.adapters.UserCheckService;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mernisCheckService")
public class MernisServiceAdapter implements UserCheckService {

    @Override
    public boolean checkIfRealPerson(IndividualUser individualUser) {
        return true;
    }
}
