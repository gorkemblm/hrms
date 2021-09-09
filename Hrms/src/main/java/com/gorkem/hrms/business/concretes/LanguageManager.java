package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.LanguageService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.ErrorResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.LanguageDao;
import com.gorkem.hrms.entities.concretes.Language;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.LanguageForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;
    private final CurriculumVitaeService curriculumVitaeService;
    private final ModelMapper modelMapper;

    public LanguageManager(LanguageDao languageDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.languageDao = languageDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(Language language) {
        Language value = null;

        try {
            value = this.languageDao.save(language);

            if (value.getId() == 0 || value.getLanguage().equals("")) {
                throw new Exception();
            } else {
                return new SuccessResult(Messages.ADD_SUCCESSFUL);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorResult(Messages.ADD_FAILED);
        }
    }

    @Override
    public Result addLanguageForJobSeeker(LanguageForCurriculumVitaeDto languageForCurriculumVitaeDto) {
        Language language = modelMapper.map(languageForCurriculumVitaeDto, Language.class);

        return add(language);
    }
}
