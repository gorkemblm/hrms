package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.UserCheckService;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import org.springframework.stereotype.Service;

@Service
public class UserCheckManager implements UserCheckService {

    //fake
    @Override
    public boolean checkIfRealPerson(IndividualUser individualUser) {
        return true;
    }
}
