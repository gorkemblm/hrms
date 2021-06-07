package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SocialMediaAccountForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/socialMediaAccounts")
public class SocialMediaAccountsController {

    private SocialMediaAccountService socialMediaAccountService;

    @Autowired
    public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
        this.socialMediaAccountService = socialMediaAccountService;
    }

    @PostMapping("/addSocialMediaAccountForJobSeeker")
    public Result addSocialMediaAccountForJobSeeker(@Valid @RequestBody SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        return this.socialMediaAccountService.addSocialMediaAccountForJobSeeker(socialMediaAccountForCurriculumVitaeDto);
    }
}
