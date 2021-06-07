package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Language;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.LanguageForCurriculumVitaeDto;

public interface LanguageService {

    Result add(Language language);

    Result addLanguageForJobSeeker(LanguageForCurriculumVitaeDto languageForCurriculumVitaeDto);
}
