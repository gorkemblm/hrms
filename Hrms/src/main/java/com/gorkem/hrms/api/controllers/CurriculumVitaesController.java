package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result addCoverLetterForJobSeeker(@RequestBody CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {
        return this.curriculumVitaeService.addCoverLetterForJobSeeker(coverLetterForCurriculumVitaeDto);
    }
}
