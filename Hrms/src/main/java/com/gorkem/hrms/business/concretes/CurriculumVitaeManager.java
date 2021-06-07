package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.*;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessDataResult;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import com.gorkem.hrms.entities.concretes.*;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CoverLetterForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {

        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public CurriculumVitae findById(int id) {
        return this.curriculumVitaeDao.findById(id);
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(Messages.successfullyListed, this.curriculumVitaeDao.findAll());
    }

    @Override
    public Result addCoverLetterForJobSeeker(CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {

        CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(coverLetterForCurriculumVitaeDto.getCurriculumVitaeId());

        curriculumVitae.setCoverLetter(coverLetterForCurriculumVitaeDto.getCoverLetter());
        this.curriculumVitaeDao.save(curriculumVitae);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
