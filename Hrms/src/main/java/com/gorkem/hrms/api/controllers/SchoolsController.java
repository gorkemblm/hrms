package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SchoolService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.School;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SchoolForCurriculumVitaeDto;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<School>>> getAll() {
        return ResponseEntity.ok(this.schoolService.getAll());
    }

    @PostMapping("/add-school")
    public ResponseEntity<Result> add(@RequestBody School school) {
        return ResponseEntity.ok(this.schoolService.add(school));
    }

    @PostMapping("/add-school-for-jobSeeker")
    public ResponseEntity<Result> addSchoolForJobSeeker(@Valid @RequestBody SchoolForCurriculumVitaeDto schoolForCurriculumVitaeDto) {
        return ResponseEntity.ok(this.schoolService.addSchoolForJobSeeker(schoolForCurriculumVitaeDto));
    }

    @GetMapping("/find-by-curriculumVitae_jobSeeker_id-order-by-graduation-description-asc-finished-date-desc")
    public ResponseEntity<DataResult<List<School>>> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(@RequestParam int id) {
        return ResponseEntity.ok(this.schoolService.findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(id));
    }
}
