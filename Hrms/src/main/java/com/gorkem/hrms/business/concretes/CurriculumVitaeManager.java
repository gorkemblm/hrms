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
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CurriculumVitaeAddForJobSeekerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private final CurriculumVitaeDao curriculumVitaeDao;
    private final JobSeekerService jobSeekerService;
    private final ModelMapper modelMapper;

    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, JobSeekerService jobSeekerService, ModelMapper modelMapper) {
        this.curriculumVitaeDao = curriculumVitaeDao;
        this.jobSeekerService = jobSeekerService;
        this.modelMapper = modelMapper;
    }

    @Override
    public CurriculumVitae findByJobSeeker_Id(int id) {
        return this.curriculumVitaeDao.findByJobSeeker_Id(id);
    }

    @Override
    public CurriculumVitae findById(int id) {
        return this.curriculumVitaeDao.findById(id);
    }

    @Override
    public Result curriculumVitaeAddForJobSeeker(CurriculumVitaeAddForJobSeekerDto curriculumVitaeAddForJobSeekerDto) {
        CurriculumVitae curriculumVitae = modelMapper.map(curriculumVitaeAddForJobSeekerDto, CurriculumVitae.class);

        this.curriculumVitaeDao.save(curriculumVitae);

        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(Messages.successfullyListed, this.curriculumVitaeDao.findAll());
    }

    @Override
    public Result addCoverLetterForJobSeeker(CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {

        CurriculumVitae curriculumVitae = modelMapper.map(coverLetterForCurriculumVitaeDto, CurriculumVitae.class);

        this.curriculumVitaeDao.save(curriculumVitae);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
