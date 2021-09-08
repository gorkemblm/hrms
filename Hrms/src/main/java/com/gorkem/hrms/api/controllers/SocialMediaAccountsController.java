package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SocialMediaAccountForCurriculumVitaeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/social-media-accounts")
public class SocialMediaAccountsController {

    private final SocialMediaAccountService socialMediaAccountService;

    public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
        this.socialMediaAccountService = socialMediaAccountService;
    }

    @PostMapping("/add-social-media-account-for-job-seeker")
    public ResponseEntity<Result> addSocialMediaAccountForJobSeeker(@Valid @RequestBody SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        var result = this.socialMediaAccountService.addSocialMediaAccountForJobSeeker(socialMediaAccountForCurriculumVitaeDto);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
