package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.JobSeekerService;
import com.gorkem.hrms.core.adapters.UserCheckService;
import com.gorkem.hrms.core.utilities.email.EmailService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.JobSeekerDao;
import com.gorkem.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return new SuccessDataResult<>(Messages.successfullyListed, this.jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!userCheckService.checkIfRealPerson(jobSeeker)) {
            return new ErrorResult(Messages.notExistGovernment);
        } else if (this.jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null ||
                this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {
            return new ErrorResult(Messages.existInSystem);
        }else if (!emailService.isTheLinkClicked()) {
            return new ErrorResult(Messages.notVerifyMail);
        } else {
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult(Messages.successfullyAdded);
        }
    }

    @Override
    public DataResult<JobSeeker> findById(int id) {
        return new SuccessDataResult<>(this.jobSeekerDao.findById(id));
    }
}
