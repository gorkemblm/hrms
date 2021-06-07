package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.WorkExperience;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.WorkExperienceForCurriculumVitaeDto;

public interface WorkExperienceService {

    Result add(WorkExperience workExperience);

    Result addWorkExperienceForJobSeeker(WorkExperienceForCurriculumVitaeDto workExperienceForCurriculumVitaeDto);
}
