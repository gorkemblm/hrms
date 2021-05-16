package com.demo.hrms.business.abstracts;

import com.demo.hrms.entities.concretes.CorporateUser;
import java.util.List;

public interface CorporateUserService {
    List<CorporateUser> getAll();
}
