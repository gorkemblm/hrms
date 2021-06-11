package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.LanguageService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.LanguageDao;
import com.gorkem.hrms.entities.concretes.Language;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.LanguageForCurriculumVitaeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private CurriculumVitaeService curriculumVitaeService;
    private ModelMapper modelMapper;

    @Autowired
    public LanguageManager(LanguageDao languageDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.languageDao = languageDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addLanguageForJobSeeker(LanguageForCurriculumVitaeDto languageForCurriculumVitaeDto) {

        Language language = modelMapper.map(languageForCurriculumVitaeDto, Language.class);

        this.languageDao.save(language);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
