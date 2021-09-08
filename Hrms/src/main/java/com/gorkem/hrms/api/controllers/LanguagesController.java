package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.LanguageService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Language;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.LanguageForCurriculumVitaeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/languages")
public class LanguagesController {

    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add-language")
    public ResponseEntity<Result> add(@RequestBody Language language) {
        return ResponseEntity.ok(this.languageService.add(language));
    }

    @PostMapping("/add-language-for-jobSeeker")
    public ResponseEntity<Result> addLanguageForJobSeeker(@Valid @RequestBody LanguageForCurriculumVitaeDto languageForCurriculumVitaeDto) {
        return ResponseEntity.ok(this.languageService.addLanguageForJobSeeker(languageForCurriculumVitaeDto));
    }
}
