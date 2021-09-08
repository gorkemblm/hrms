package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CoverLetterForCurriculumVitaeDto;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CurriculumVitaeAddForJobSeekerDto;
import org.springframework.http.HttpStatus;
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
        var result = this.curriculumVitaeService.getAll();

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-cover-letter")
    public ResponseEntity<Result> addCoverLetterForJobSeeker(@Valid @RequestBody CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {
        var result = this.curriculumVitaeService.addCoverLetterForJobSeeker(coverLetterForCurriculumVitaeDto);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-curriculum-vitae")
    public ResponseEntity<Result> curriculumVitaeAddForJobSeeker(@RequestBody CurriculumVitaeAddForJobSeekerDto curriculumVitaeAddForJobSeekerDto) {
        var result = this.curriculumVitaeService.curriculumVitaeAddForJobSeeker(curriculumVitaeAddForJobSeekerDto);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
