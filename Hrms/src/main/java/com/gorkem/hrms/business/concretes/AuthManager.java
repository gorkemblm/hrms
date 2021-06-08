package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.AuthService;
import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.business.abstracts.JobSeekerService;
import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.entities.concretes.Employer;
import com.gorkem.hrms.entities.concretes.JobSeeker;
import com.gorkem.hrms.entities.dtos.authDtos.EmployerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.JobSeekerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private JobSeekerService jobSeekerService;
    private EmployerService employerService;
    private UserService userService;

    @Autowired
    public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService, UserService userService) {
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
        this.userService = userService;
    }

    @Override
    public Result loginForUser(UserForLoginDto userForLoginDto) {
        boolean result = this.userService.findByEmailAndPasswordHash(userForLoginDto.getEmail(), userForLoginDto.getPassword());

        if (!result) {
            return new ErrorResult();
        }else {
            return new SuccessResult();
        }
    }

    @Override
    public Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        JobSeeker jobSeeker = new JobSeeker();

        jobSeeker.setNumberOfApplication(0);

        jobSeeker.setActive(true);

        jobSeeker.setEmail(jobSeekerForRegisterDto.getEmail());
        jobSeeker.setPasswordHash(jobSeekerForRegisterDto.getPassword());
        jobSeeker.setFirstName(jobSeekerForRegisterDto.getFirstName());
        jobSeeker.setLastName(jobSeekerForRegisterDto.getLastName());
        jobSeeker.setIdentityNumber(jobSeekerForRegisterDto.getIdentityNumber());
        jobSeeker.setDateOfBirth(jobSeekerForRegisterDto.getDateOfBirth());

        return this.jobSeekerService.add(jobSeeker);
    }

    @Override
    public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
        Employer employer = new Employer();

        employer.setActive(true);

        employer.setApproveStatus(false);

        employer.setWebsite(employerForRegisterDto.getWebSite());
        employer.setEmail(employerForRegisterDto.getEmail());
        employer.setPasswordHash(employerForRegisterDto.getPassword());
        employer.setCompanyName(employerForRegisterDto.getCompanyName());
        employer.setPhoneNumber(employerForRegisterDto.getPhoneNumber());

        return this.employerService.add(employer);
    }
}
