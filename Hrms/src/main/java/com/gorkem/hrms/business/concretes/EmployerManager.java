package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.core.utilities.email.EmailService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.EmployerDao;
import com.gorkem.hrms.entities.concretes.Employer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Slf4j
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
        Employer value = null;

        try {
            value = this.employerDao.findById(id);

            if (value.getId() == 0 || value.getEmail().equals("")){
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.FIND_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.FIND_FAILED);
        }
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {
        Employer value = null;
        if (!isCompanyEmail(employer.getEmail(), employer.getWebsite())) {
            log.info("CUSTOM MESSAGE : {}. DATA : {}.", Messages.WRONG_MAIL_FORMAT, employer);
            return new ErrorResult(Messages.WRONG_MAIL_FORMAT);

        } else if (this.employerDao.findByEmail(employer.getEmail()) != null) {
            log.info("CUSTOM MESSAGE : {}. DATA : {}.", Messages.EXIST_IN_SYSTEM, employer);
            return new ErrorResult(Messages.EXIST_IN_SYSTEM);

        } else if (!emailService.isTheLinkClicked()) {
            log.info("CUSTOM MESSAGE : {}. DATA : {}.", Messages.MAIL_NOT_VERIFY, employer);
            return new ErrorResult(Messages.MAIL_NOT_VERIFY);

        } else {
            try {
                value = this.employerDao.save(employer);

                if (value.getId() == 0 || value.getEmail().equals("")) {
                    throw new Exception();
                } else {
                    return new SuccessResult(Messages.ADD_SUCCESSFUL);
                }
            } catch (Exception e) {
                log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
                return new ErrorResult(Messages.ADD_FAILED);
            }
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
