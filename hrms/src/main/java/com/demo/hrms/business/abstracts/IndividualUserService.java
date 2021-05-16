package com.demo.hrms.business.abstracts;

import com.demo.hrms.entities.concretes.IndividualUser;
import java.util.List;

public interface IndividualUserService {

    List<IndividualUser> getAll();
}
