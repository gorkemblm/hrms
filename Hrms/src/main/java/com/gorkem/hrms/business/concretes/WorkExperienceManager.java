package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.WorkExperienceService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.WorkExperinceDao;
import com.gorkem.hrms.entities.concretes.WorkExperience;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.WorkExperienceForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WorkExperienceManager implements WorkExperienceService {

    private final WorkExperinceDao workExperinceDao;
    private final CurriculumVitaeService curriculumVitaeService;
    private final ModelMapper modelMapper;

    public WorkExperienceManager(WorkExperinceDao workExperinceDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.workExperinceDao = workExperinceDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        WorkExperience value = null;

        try {
            value = this.workExperinceDao.save(workExperience);

            if (value.getId() == 0 || value.getCompanyName().equals("")) {
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
    public DataResult<List<WorkExperience>> findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(int id) {
        List<WorkExperience> value = null;

        try {
            value = this.workExperinceDao.findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(id);

            if (id == 0 || value.isEmpty()) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.LIST_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.LIST_FAILED, value);
        }
    }

    @Override
    public Result addWorkExperienceForJobSeeker(WorkExperienceForCurriculumVitaeDto workExperienceForCurriculumVitaeDto) {
        WorkExperience workExperience = modelMapper.map(workExperienceForCurriculumVitaeDto, WorkExperience.class);

        if (!workExperienceForCurriculumVitaeDto.isStillWork()) {
            workExperience.setFinishedDate(workExperienceForCurriculumVitaeDto.getFinishedDateJob());
            workExperience.setWorkingDescription("Finished");
        } else {
            workExperience.setStillWork(workExperienceForCurriculumVitaeDto.isStillWork());
            workExperience.setWorkingDescription("Continues");
        }

        add(workExperience);

        return new SuccessResult(Messages.ADD_SUCCESSFUL);
    }
}
