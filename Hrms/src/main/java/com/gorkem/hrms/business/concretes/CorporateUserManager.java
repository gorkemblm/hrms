package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CorporateUserService;
import com.gorkem.hrms.core.utils.verifications.Regex;
import com.gorkem.hrms.core.utils.security.PasswordHash;
import com.gorkem.hrms.dataAccess.abstracts.CorporateUserDao;
import com.gorkem.hrms.entities.concretes.CorporateUser;
import com.gorkem.hrms.entities.concretes.dtos.CorporateUserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
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
        return corporateUserDao.findAll();
    }

    @Override
    public CorporateUser save(CorporateUserRegisterDto corporateUserRegisterDto) throws NoSuchAlgorithmException {
        if (Regex.verify(corporateUserRegisterDto.getEmail(), corporateUserRegisterDto.getCompanyName())) {
            String passwordHash = PasswordHash.generateHash(corporateUserRegisterDto.getPassword());
            CorporateUser corporateUser = new CorporateUser();
            corporateUser.setEmail(corporateUserRegisterDto.getEmail());
            corporateUser.setPasswordHash(passwordHash);
            corporateUser.setCompanyName(corporateUserRegisterDto.getCompanyName());
            corporateUser.setWebsite(corporateUserRegisterDto.getWebSite());
            corporateUser.setActive(true);
            corporateUser.setCreatedAt(LocalDate.now());
            corporateUser.setUpdatedAt(LocalDate.now());
            corporateUser.setApproveStatus(false);

            return this.corporateUserDao.save(corporateUser);

        } else {
            return null;

        }
    }

}
