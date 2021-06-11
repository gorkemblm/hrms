package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CoverLetterForCurriculumVitaeDto;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CurriculumVitaeAddForJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/curriculumVitaes")
public class CurriculumVitaesController {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CurriculumVitae>> getAll() {
        return this.curriculumVitaeService.getAll();
    }

    @PostMapping("/addCoverLetterForJobSeeker")
    public Result addCoverLetterForJobSeeker(@Valid @RequestBody CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {
        return this.curriculumVitaeService.addCoverLetterForJobSeeker(coverLetterForCurriculumVitaeDto);
    }

    @PostMapping("/curriculumVitaeAddForJobSeeker")
    public Result curriculumVitaeAddForJobSeeker(@RequestBody CurriculumVitaeAddForJobSeekerDto curriculumVitaeAddForJobSeekerDto) {
        return this.curriculumVitaeService.curriculumVitaeAddForJobSeeker(curriculumVitaeAddForJobSeekerDto);
    }
}
