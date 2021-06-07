package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.LanguageService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Language;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.LanguageForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return this.languageService.add(language);
    }

    @PostMapping("/addLanguageForJobSeeker")
    public Result addLanguageForJobSeeker(@Valid @RequestBody LanguageForCurriculumVitaeDto languageForCurriculumVitaeDto) {
        return this.languageService.addLanguageForJobSeeker(languageForCurriculumVitaeDto);
    }
}
