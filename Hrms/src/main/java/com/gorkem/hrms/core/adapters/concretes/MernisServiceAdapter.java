package com.gorkem.hrms.core.adapters.concretes;

import com.gorkem.hrms.core.adapters.abstracts.VerificationService;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements VerificationService {

    //if I want the add The Mernis client, this is gonna easy.

    @Override
    public boolean isRealPerson(IndividualUser individualUser) {

        return true;
        //Simulation
    }
}
