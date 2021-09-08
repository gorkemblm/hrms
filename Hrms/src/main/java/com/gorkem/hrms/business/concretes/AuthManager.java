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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private final JobSeekerService jobSeekerService;
    private final EmployerService employerService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService, UserService userService, ModelMapper modelMapper) {
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result loginForUser(UserForLoginDto userForLoginDto) {
        boolean result = this.userService.findByEmailAndPassword(userForLoginDto.getEmail(), userForLoginDto.getPassword());

        if (!result) {
            return new ErrorResult();
        }else {
            return new SuccessResult();
        }
    }

    @Override
    public Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto) {

        JobSeeker jobSeeker = modelMapper.map(jobSeekerForRegisterDto, JobSeeker.class);

        jobSeeker.setNumberOfApplication(0);

        jobSeeker.setActive(true);

        return this.jobSeekerService.add(jobSeeker);
    }

    @Override
    public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {

        Employer employer = modelMapper.map(employerForRegisterDto, Employer.class);

        employer.setActive(true);

        employer.setApproveStatus(false);

        return this.employerService.add(employer);
    }
}
