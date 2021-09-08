package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.AuthService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.authDtos.EmployerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.JobSeekerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.UserForLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/auths")
@CrossOrigin
public class AuthsController {

    private final AuthService authService;

    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-jobSeeker")
    public ResponseEntity<Result> registerForJobSeeker(@Valid @RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {

        return ResponseEntity.ok(this.authService.registerForJobSeeker(jobSeekerForRegisterDto));
    }

    @PostMapping("/register-employer")
    public ResponseEntity<Result> registerForEmployer(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto) {

        return ResponseEntity.ok(this.authService.registerForEmployer(employerForRegisterDto));
    }

    @PostMapping("/login-user")
    public ResponseEntity<Result> loginForUser(@Valid @RequestBody UserForLoginDto userForLoginDto) {

        return ResponseEntity.ok(this.authService.loginForUser(userForLoginDto));
    }
}
