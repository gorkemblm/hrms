package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.AuthService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.authDtos.EmployerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.JobSeekerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {

    private AuthService authService;

    @Autowired
    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerForJobSeeker")
    Result registerForJobSeeker(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        return this.authService.registerForJobSeeker(jobSeekerForRegisterDto);
    }

    @PostMapping("/registerForEmployer")
    public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
        return this.authService.registerForEmployer(employerForRegisterDto);
    }

    @PostMapping("/loginForUser")
    Result loginForUser(@RequestBody UserForLoginDto userForLoginDto) {
        return this.authService.loginForUser(userForLoginDto);
    }
}
