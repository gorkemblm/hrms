package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.SchoolService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessDataResult;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.SchoolDao;
import com.gorkem.hrms.entities.concretes.School;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SchoolForCurriculumVitaeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return new SuccessDataResult<>(Messages.successfullyListed, this.schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public DataResult<List<School>> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(int id) {
        return new SuccessDataResult<>(Messages.successfullyListed,this.schoolDao.findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(id));
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

        this.schoolDao.save(school);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
