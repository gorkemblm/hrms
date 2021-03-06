package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.School;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SchoolForCurriculumVitaeDto;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAll();

    Result add(School school);

    Result addSchoolForJobSeeker(SchoolForCurriculumVitaeDto schoolForCurriculumVitaeDto);

    DataResult<List<School>> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(int id);
}
