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
import com.gorkem.hrms.entities.dtos.SchoolForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public SchoolManager(SchoolDao schoolDao, CurriculumVitaeService curriculumVitaeService) {
        this.schoolDao = schoolDao;
        this.curriculumVitaeService = curriculumVitaeService;
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
    public Result addSchoolForJobSeeker(SchoolForCurriculumVitaeDto schoolForCurriculumVitaeDto) {

        School school = new School();

        school.setCurriculumVitae(this.curriculumVitaeService.findById(schoolForCurriculumVitaeDto.getCurriculumVitaeId()));

        school.setSchoolName(schoolForCurriculumVitaeDto.getSchoolName());

        school.setDepartment(schoolForCurriculumVitaeDto.getDepartment());
        school.setStartedDate(schoolForCurriculumVitaeDto.getStartedDateSchool());

        if (schoolForCurriculumVitaeDto.isGraduationStatus()) {
            school.setFinishedDate(schoolForCurriculumVitaeDto.getFinishedDateSchool());
        } else {
            school.setGraduationStatus(schoolForCurriculumVitaeDto.isGraduationStatus());
        }

        this.schoolDao.save(school);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
