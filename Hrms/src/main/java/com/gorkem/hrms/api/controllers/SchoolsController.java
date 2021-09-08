package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SchoolService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.School;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SchoolForCurriculumVitaeDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/schools")
public class SchoolsController {

    private final SchoolService schoolService;

    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/get-all-schools")
    public DataResult<List<School>> getAll() {
        return this.schoolService.getAll();
    }

    @PostMapping("/add-school")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @PostMapping("/add-school-for-jobSeeker")
    public Result addSchoolForJobSeeker(@Valid @RequestBody SchoolForCurriculumVitaeDto schoolForCurriculumVitaeDto) {
        return this.schoolService.addSchoolForJobSeeker(schoolForCurriculumVitaeDto);
    }

    @GetMapping("/find-by-curriculumVitae_jobSeeker_id-order-by-graduation-description-asc-finished-date-desc")
    public DataResult<List<School>> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(@RequestParam int id) {
        return this.schoolService.findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(id);
    }
}
