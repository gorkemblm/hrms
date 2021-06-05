package com.gorkem.hrms.core.adapters.mernis;

import com.gorkem.hrms.entities.abstracts.IndividualUser;

public interface AuthenticationService {

    boolean isRealPerson(IndividualUser individualUser);
}
