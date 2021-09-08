package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SocialMediaAccountForCurriculumVitaeDto;
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
    public Result addSocialMediaAccountForJobSeeker(@Valid @RequestBody SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        return this.socialMediaAccountService.addSocialMediaAccountForJobSeeker(socialMediaAccountForCurriculumVitaeDto);
    }
}
