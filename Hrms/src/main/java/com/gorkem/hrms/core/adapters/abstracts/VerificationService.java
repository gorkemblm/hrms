package com.gorkem.hrms.core.adapters.abstracts;

import com.gorkem.hrms.entities.abstracts.IndividualUser;

public interface VerificationService {

    boolean isRealPerson(IndividualUser individualUser);
}
