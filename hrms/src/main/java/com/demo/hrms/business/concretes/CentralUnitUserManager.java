package com.demo.hrms.business.concretes;

import com.demo.hrms.business.abstracts.CentralUnitUserService;
import com.demo.hrms.dataAccess.abstracts.CentralUserDao;
import com.demo.hrms.entities.concretes.CentralUnitUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentralUnitUserManager implements CentralUnitUserService {

    private CentralUserDao centralUserDao;

    @Autowired
    public CentralUnitUserManager(CentralUserDao centralUserDao) {
        this.centralUserDao = centralUserDao;
    }

    @Override
    public List<CentralUnitUser> getAll() {
        return this.centralUserDao.findAll();
    }
}
