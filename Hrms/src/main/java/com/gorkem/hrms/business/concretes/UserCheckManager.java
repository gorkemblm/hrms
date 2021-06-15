package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.core.adapters.UserCheckService;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("defaultCheckService")
public class UserCheckManager implements UserCheckService {

    @Override
    public boolean checkIfRealPerson(IndividualUser individualUser) {
        return true;
    }
}
