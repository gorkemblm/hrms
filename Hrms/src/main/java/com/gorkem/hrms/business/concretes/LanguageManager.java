package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.LanguageService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.LanguageDao;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.concretes.Language;
import com.gorkem.hrms.entities.dtos.LanguageForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public LanguageManager(LanguageDao languageDao, CurriculumVitaeService curriculumVitaeService) {
        this.languageDao = languageDao;
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addLanguageForJobSeeker(LanguageForCurriculumVitaeDto languageForCurriculumVitaeDto) {

        Language language = new Language();

        language.setCurriculumVitae(this.curriculumVitaeService.findById(languageForCurriculumVitaeDto.getCurriculumVitaeId()));

        language.setLanguage(languageForCurriculumVitaeDto.getLanguage());
        language.setLevel(languageForCurriculumVitaeDto.getLevel());

        this.languageDao.save(language);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
