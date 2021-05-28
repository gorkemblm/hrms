package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.core.utilities.email.abstracts.EmailService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.EmployerDao;
import com.gorkem.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailService emailService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(Messages.successfullyListed, this.employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {

        if (!isFieldsEmpty(
                employer.getEmail(),
                employer.getWebsite(),
                employer.getEmail(),
                employer.getPasswordHash(),
                employer.getPhoneNumber(),
                employer.getCompanyName())
        ) {
            return new ErrorResult(Messages.requiredFields);
        } else if (!isCompanyEmail(employer.getEmail(), employer.getWebsite())) {
            return new ErrorResult(Messages.wrongMailFormat);
        } else if (this.employerDao.findByEmail(employer.getEmail()) != null) {
            return new ErrorResult(Messages.existInSystem);
        } else if (!emailService.isTheLinkClicked()) {
            return new ErrorResult(Messages.notVerifyMail);
        } else {
            this.employerDao.save(employer);
            return new SuccessResult(Messages.successfullyAdded);
        }
    }

    private boolean isCompanyEmail(String email, String webSite) {

        if (email == null || email.isEmpty()) return false;

        String[] array = webSite.split(".");

        String finalString = "";

        for (int i = 1; i < array.length; i++) {
            finalString += array[i];
        }

        String emailRegex = "info@" + finalString;
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public boolean isFieldsEmpty(String... args) {
        for (String s : args) {
            if (s.isEmpty() || s == null) {
                return true;
            }
        }
        return false;
    }

}
