package com.demo.hrms.business.concretes;

import com.demo.hrms.business.abstracts.CorporateUserService;
import com.demo.hrms.dataAccess.abstracts.CorporateUserDao;
import com.demo.hrms.entities.concretes.CorporateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CorporateUserManager implements CorporateUserService {

    private CorporateUserDao corporateUserDao;

    @Autowired
    public CorporateUserManager(CorporateUserDao corporateUserDao) {
        this.corporateUserDao = corporateUserDao;
    }

    @Override
    public List<CorporateUser> getAll() {
        return this.corporateUserDao.findAll();
    }
}
