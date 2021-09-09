package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.JobSeekerService;
import com.gorkem.hrms.core.adapters.UserCheckService;
import com.gorkem.hrms.core.utilities.email.EmailService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.JobSeekerDao;
import com.gorkem.hrms.entities.concretes.JobSeeker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobSeekerManager implements JobSeekerService {

    private final JobSeekerDao jobSeekerDao;
    private final UserCheckService userCheckService;
    private final EmailService emailService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao
            ,@Qualifier("defaultCheckService")UserCheckService userCheckService
            ,@Qualifier("defaultEmailService")EmailService emailService) {

        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        JobSeeker value = null;

        if (!userCheckService.checkIfRealPerson(jobSeeker)) {
            log.error("CUSTOM MESSAGE : {}. DATA : {}.", Messages.NOT_PERSON, jobSeeker);
            return new ErrorResult(Messages.NOT_PERSON);

        } else if (this.jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null || this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {
            log.error("CUSTOM MESSAGE : {}. DATA : {}.", Messages.EXIST_IN_SYSTEM, jobSeeker);
            return new ErrorResult(Messages.EXIST_IN_SYSTEM);

        }else if (!emailService.isTheLinkClicked()) {
            log.error("CUSTOM MESSAGE : {}. DATA : {}.", Messages.MAIL_NOT_VERIFY, jobSeeker);
            return new ErrorResult(Messages.MAIL_NOT_VERIFY);

        } else {
            try {
                value = this.jobSeekerDao.save(jobSeeker);

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

    @Override
    public DataResult<JobSeeker> findById(int id) {
        JobSeeker value = null;

        try {
            value = this.jobSeekerDao.findById(id);

            if (id == 0 || value.getId() == 0) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.FIND_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.FIND_FAILED);
        }
    }
}
