package com.gorkem.hrms.core.adapters;

import com.gorkem.hrms.entities.abstracts.IndividualUser;

public interface UserCheckService {

    boolean checkIfRealPerson(IndividualUser individualUser);
}
