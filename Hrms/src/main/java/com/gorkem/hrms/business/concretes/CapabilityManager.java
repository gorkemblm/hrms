package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CapabilityService;
import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.CapabilityDao;
import com.gorkem.hrms.entities.concretes.Capability;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CapabilityForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapabilityManager implements CapabilityService {

    private CapabilityDao capabilityDao;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CapabilityManager(CapabilityDao capabilityDao, CurriculumVitaeService curriculumVitaeService) {
        this.capabilityDao = capabilityDao;
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @Override
    public Result add(Capability capability) {
        this.capabilityDao.save(capability);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addForJobSeeker(CapabilityForCurriculumVitaeDto capabilityForCurriculumVitaeDto) {
        Capability capability = new Capability();

        capability.setCurriculumVitae(this.curriculumVitaeService.findById(capabilityForCurriculumVitaeDto.getCurriculumVitaeId()));

        capability.setType(capabilityForCurriculumVitaeDto.getCapabilityType());
        capability.setName(capabilityForCurriculumVitaeDto.getCapabilityName());

        this.capabilityDao.save(capability);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
