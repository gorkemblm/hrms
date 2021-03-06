package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.AuthService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.authDtos.EmployerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.JobSeekerForRegisterDto;
import com.gorkem.hrms.entities.dtos.authDtos.UserForLoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/auths")
@CrossOrigin
public class AuthsController {

    private final AuthService authService;

    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-job-seeker")
    public ResponseEntity<Result> registerForJobSeeker(@Valid @RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        var result = this.authService.registerForJobSeeker(jobSeekerForRegisterDto);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register-employer")
    public ResponseEntity<Result> registerForEmployer(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto) {
        var result = this.authService.registerForEmployer(employerForRegisterDto);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login-user")
    public ResponseEntity<Result> loginForUser(@Valid @RequestBody UserForLoginDto userForLoginDto) {
        var result = this.authService.loginForUser(userForLoginDto);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
