package com.demo.hrms.business.concretes;

import com.demo.hrms.business.abstracts.IndividualUserService;
import com.demo.hrms.dataAccess.abstracts.IndividualUserDao;
import com.demo.hrms.entities.concretes.IndividualUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualUserManager implements IndividualUserService {

    private IndividualUserDao individualUserDao;

    @Autowired
    public IndividualUserManager(IndividualUserDao individualUserDao) {
        this.individualUserDao = individualUserDao;
    }

    @Override
    public List<IndividualUser> getAll() {
        return this.individualUserDao.findAll();
    }
}
