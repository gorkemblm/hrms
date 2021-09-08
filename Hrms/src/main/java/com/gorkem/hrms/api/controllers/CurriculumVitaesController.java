package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CoverLetterForCurriculumVitaeDto;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CurriculumVitaeAddForJobSeekerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/curriculum-vitaes")
public class CurriculumVitaesController {

    private final CurriculumVitaeService curriculumVitaeService;

    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping("/get-all-curriculum-vitaes")
    public ResponseEntity<DataResult<List<CurriculumVitae>>> getAll() {
        return ResponseEntity.ok(this.curriculumVitaeService.getAll());
    }

    @PostMapping("/add-cover-letter")
    public ResponseEntity<Result> addCoverLetterForJobSeeker(@Valid @RequestBody CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {
        return ResponseEntity.ok(this.curriculumVitaeService.addCoverLetterForJobSeeker(coverLetterForCurriculumVitaeDto));
    }

    @PostMapping("/add-curriculum-vitae")
    public ResponseEntity<Result> curriculumVitaeAddForJobSeeker(@RequestBody CurriculumVitaeAddForJobSeekerDto curriculumVitaeAddForJobSeekerDto) {
        return ResponseEntity.ok(this.curriculumVitaeService.curriculumVitaeAddForJobSeeker(curriculumVitaeAddForJobSeekerDto));
    }
}
