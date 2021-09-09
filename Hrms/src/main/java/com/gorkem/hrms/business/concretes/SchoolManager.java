package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.SchoolService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.SchoolDao;
import com.gorkem.hrms.entities.concretes.School;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SchoolForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SchoolManager implements SchoolService {

    private final SchoolDao schoolDao;
    private final CurriculumVitaeService curriculumVitaeService;
    private final ModelMapper modelMapper;

    public SchoolManager(SchoolDao schoolDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.schoolDao = schoolDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        School value = null;

        try {
            value = this.schoolDao.save(school);

            if (value.getId() == 0 || value.getSchoolName().equals("")) {
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
    public DataResult<List<School>> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(int id) {
        List<School> value = null;

        try {
            value = this.schoolDao.findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(id);

            if (id == 0 || value.isEmpty()) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.LIST_FAILED, value);
        }
    }

    @Override
    public Result addSchoolForJobSeeker(SchoolForCurriculumVitaeDto schoolForCurriculumVitaeDto) {

        School school = modelMapper.map(schoolForCurriculumVitaeDto, School.class);

        if (schoolForCurriculumVitaeDto.isGraduationStatus()) {
            school.setGraduationDescription("Finished");
            school.setFinishedDate(schoolForCurriculumVitaeDto.getFinishedDateSchool());
        } else {
            school.setGraduationDescription("Continues");
            school.setGraduationStatus(schoolForCurriculumVitaeDto.isGraduationStatus());
        }

        add(school);

        return new SuccessResult(Messages.ADD_SUCCESSFUL);
    }
}
