package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.WorkExperienceService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.WorkExperinceDao;
import com.gorkem.hrms.entities.concretes.WorkExperience;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.WorkExperienceForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperinceDao workExperinceDao;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public WorkExperienceManager(WorkExperinceDao workExperinceDao, CurriculumVitaeService curriculumVitaeService) {
        this.workExperinceDao = workExperinceDao;
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        this.workExperinceDao.save(workExperience);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addWorkExperienceForJobSeeker(WorkExperienceForCurriculumVitaeDto workExperienceForCurriculumVitaeDto) {
        WorkExperience workExperience = new WorkExperience();

        workExperience.setCurriculumVitae(this.curriculumVitaeService.findById(workExperienceForCurriculumVitaeDto.getCurriculumVitaeId()));

        workExperience.setCompanyName(workExperienceForCurriculumVitaeDto.getCompanyName());
        workExperience.setPosition(workExperienceForCurriculumVitaeDto.getPosition());
        workExperience.setStartedDate(workExperienceForCurriculumVitaeDto.getStartedDateJob());

        if (!workExperienceForCurriculumVitaeDto.isStillWork()) {
            workExperience.setFinishedDate(workExperienceForCurriculumVitaeDto.getFinishedDateJob());
        } else {
            workExperience.setStillWork(workExperienceForCurriculumVitaeDto.isStillWork());
        }

        this.workExperinceDao.save(workExperience);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
