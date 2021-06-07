package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.WorkExperienceService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.WorkExperienceForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperiencesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping("/addWorkExperienceForJobSeeker")
    public Result addWorkExperienceForJobSeeker(@Valid @RequestBody WorkExperienceForCurriculumVitaeDto workExperienceForCurriculumVitaeDto) {
        return this.workExperienceService.addWorkExperienceForJobSeeker(workExperienceForCurriculumVitaeDto);
    }
}
