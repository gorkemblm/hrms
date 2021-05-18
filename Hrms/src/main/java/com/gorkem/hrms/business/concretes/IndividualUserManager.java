package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.IndividualUserService;
import com.gorkem.hrms.core.adapters.MernisServiceAdapter;
import com.gorkem.hrms.core.utils.security.PasswordHash;
import com.gorkem.hrms.dataAccess.abstracts.IndividualUserDao;
import com.gorkem.hrms.entities.concretes.IndividualUser;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public IndividualUser save(IndividualUserRegisterDto individualUserRegisterDto) throws Exception {

        String passwordHash = PasswordHash.generateHash(individualUserRegisterDto.getPassword());

        boolean result = MernisServiceAdapter.mernisServiceValidation(individualUserRegisterDto);

        if (result) {

            IndividualUser individualUser = new IndividualUser();

            individualUser.setEmail(individualUserRegisterDto.getEmail());
            individualUser.setPasswordHash(passwordHash);
            individualUser.setFirstName(individualUserRegisterDto.getFirstName());
            individualUser.setLastName(individualUserRegisterDto.getLastName());
            individualUser.setIdentityNumber(individualUserRegisterDto.getIdentityNumber());
            individualUser.setDateOfBirth(individualUserRegisterDto.getDateOfBirth());
            individualUser.setGender(individualUserRegisterDto.getGender());
            individualUser.setCreatedAt(LocalDate.now());
            individualUser.setUpdatedAt(LocalDate.now());
            individualUser.setActive(true);

            IndividualUser finalIndividualUser = this.individualUserDao.save(individualUser);
            return finalIndividualUser;

        } else {
            return null;
        }
    }
}
