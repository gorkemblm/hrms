package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.WorkExperienceService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.WorkExperience;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.WorkExperienceForCurriculumVitaeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/work-experiences")
public class WorkExperiencesController {

    private final WorkExperienceService workExperienceService;

    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @GetMapping("/find-by-curriculumVitae_jobSeeker_id-order-by-working-description-asc-finished-date-desc-work-experience")
    public ResponseEntity<DataResult<List<WorkExperience>>> findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(@RequestParam int id) {
        var result = this.workExperienceService.findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(id);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-work-experience-for-job-seeker")
    public ResponseEntity<Result> addWorkExperienceForJobSeeker(@Valid @RequestBody WorkExperienceForCurriculumVitaeDto workExperienceForCurriculumVitaeDto) {
        var result = this.workExperienceService.addWorkExperienceForJobSeeker(workExperienceForCurriculumVitaeDto);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
