package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.*;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import com.gorkem.hrms.entities.concretes.*;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CoverLetterForCurriculumVitaeDto;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CurriculumVitaeAddForJobSeekerDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        CurriculumVitae value = null;

        try {
            value = this.curriculumVitaeDao.findByJobSeeker_Id(id);

            if (value.getId() == 0 || id == 0 || value.getJobSeeker().getId() == 0) {
                throw new Exception();
            } else {
                return value;
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return null;
        }
    }

    @Override
    public CurriculumVitae findById(int id) {
        CurriculumVitae value = null;

        try {
            value = this.curriculumVitaeDao.findById(id);

            if (id == 0 || value.getId() == 0) {
                throw new Exception();
            } else {
                return value;
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return null;
        }
    }

    @Override
    public Result curriculumVitaeAddForJobSeeker(CurriculumVitaeAddForJobSeekerDto curriculumVitaeAddForJobSeekerDto) {
        CurriculumVitae value = null;

        try {
            value = this.curriculumVitaeDao.save(modelMapper.map(curriculumVitaeAddForJobSeekerDto, CurriculumVitae.class));

            if (value.getId() == 0 || value.getJobSeeker().getId() == 0) {
                throw new Exception();
            } else {
                return new SuccessResult(Messages.ADD_SUCCESSFUL);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return new ErrorResult(Messages.FIND_FAILED);
        }
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.curriculumVitaeDao.findAll());
    }

    @Override
    public Result addCoverLetterForJobSeeker(CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto) {
        CurriculumVitae value = null;

        try {
            value = this.curriculumVitaeDao.save(modelMapper.map(coverLetterForCurriculumVitaeDto, CurriculumVitae.class));

            if (value.getId() == 0 || value.getJobSeeker().getId() == 0) {
                throw new Exception();
            } else {
                return new SuccessResult(Messages.ADD_SUCCESSFUL);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorResult(Messages.ADD_FAILED);
        }
    }
}
