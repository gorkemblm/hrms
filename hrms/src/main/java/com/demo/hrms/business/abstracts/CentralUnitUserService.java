package com.demo.hrms.business.abstracts;

import com.demo.hrms.entities.concretes.CentralUnitUser;

import java.util.List;

public interface CentralUnitUserService {
    List<CentralUnitUser> getAll();
}
