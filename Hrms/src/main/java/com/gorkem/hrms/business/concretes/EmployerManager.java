package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.core.utilities.email.EmailService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.EmployerDao;
import com.gorkem.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private final EmailService emailService;

    public EmployerManager(EmployerDao employerDao, @Qualifier("defaultEmailService") EmailService emailService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
    }

    @Override
    public DataResult<Employer> findById(int id) {
        return new SuccessDataResult<>(this.employerDao.findById(id));
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(Messages.successfullyListed, this.employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {

        if (!isCompanyEmail(employer.getEmail(), employer.getWebsite())) {
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

        if (email == null || email.isEmpty()) {
            return false;
        }else {
            String[] array = webSite.split("www.");

            String finalString = array[1];

            String emailRegex = "info@" + finalString;
            Pattern pattern = Pattern.compile(emailRegex);

            return pattern.matcher(email).matches();
        }
    }
}
