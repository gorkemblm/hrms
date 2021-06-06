package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.entities.abstracts.IndividualUser;

public interface UserCheckService {

    boolean checkIfRealPerson(IndividualUser individualUser);
}
