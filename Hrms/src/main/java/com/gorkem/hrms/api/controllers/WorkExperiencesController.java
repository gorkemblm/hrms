package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.WorkExperienceService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.WorkExperience;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.WorkExperienceForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperiencesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @GetMapping("/findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc")
    public DataResult<List<WorkExperience>> findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(@RequestParam int id) {
        return this.workExperienceService.findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(id);
    }

    @PostMapping("/addWorkExperienceForJobSeeker")
    public Result addWorkExperienceForJobSeeker(@Valid @RequestBody WorkExperienceForCurriculumVitaeDto workExperienceForCurriculumVitaeDto) {
        return this.workExperienceService.addWorkExperienceForJobSeeker(workExperienceForCurriculumVitaeDto);
    }
}
