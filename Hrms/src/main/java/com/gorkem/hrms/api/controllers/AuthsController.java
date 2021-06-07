package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.AuthService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.ErrorResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.authDtos.EmployerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.JobSeekerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {

    private AuthService authService;

    @Autowired
    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerForJobSeeker")
    Result registerForJobSeeker(@Valid @RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {

        var result = this.authService.registerForJobSeeker(jobSeekerForRegisterDto);

        if (!result.isSuccess()) {
            return new ErrorResult(Messages.FailedToAdd);//BURADA KALDIK!
        }
        return result;
    }

    @PostMapping("/registerForEmployer")
    public Result registerForEmployer(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto) {
        var result = this.authService.registerForEmployer(employerForRegisterDto);

        if (!result.isSuccess()) {
            return new ErrorResult(Messages.FailedToAdd);
        }
        return result;
    }

    @PostMapping("/loginForUser")
    Result loginForUser(@Valid @RequestBody UserForLoginDto userForLoginDto) {
        var result = this.authService.loginForUser(userForLoginDto);

        if (!result.isSuccess()) {
            return new ErrorResult();
        }
        return result;
    }
}
