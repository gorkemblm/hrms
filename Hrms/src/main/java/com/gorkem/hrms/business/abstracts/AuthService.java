package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.authDtos.EmployerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.JobSeekerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.UserForLoginDto;

public interface AuthService {

    Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto);

    Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto);

    Result loginForUser(UserForLoginDto userForLoginDto);
}
