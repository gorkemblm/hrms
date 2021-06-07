package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.JobSeekerService;
import com.gorkem.hrms.business.abstracts.UserCheckService;
import com.gorkem.hrms.core.utilities.email.EmailService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.JobSeekerDao;
import com.gorkem.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private UserCheckService userCheckService;
    private EmailService emailService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService, EmailService emailService) {
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(Messages.successfullyListed, this.jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!userCheckService.checkIfRealPerson(jobSeeker)) {

            return new ErrorResult(Messages.notExistGovernment);

        } else if (this.jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null ||
                this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {

            return new ErrorResult(Messages.existInSystem);

        } else if (!emailService.isTheLinkClicked()) {

            return new ErrorResult(Messages.notVerifyMail);

        } else {
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult(Messages.successfullyAdded);
        }
    }

    @Override
    public JobSeeker findById(int id) {
        return this.jobSeekerDao.findById(id);
    }
}
