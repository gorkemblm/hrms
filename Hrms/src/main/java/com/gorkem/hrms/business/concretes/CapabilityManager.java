package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CapabilityService;
import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.CapabilityDao;
import com.gorkem.hrms.entities.concretes.Capability;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CapabilityForCurriculumVitaeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapabilityManager implements CapabilityService {

    private CapabilityDao capabilityDao;
    private CurriculumVitaeService curriculumVitaeService;
    private ModelMapper modelMapper;

    @Autowired
    public CapabilityManager(CapabilityDao capabilityDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.capabilityDao = capabilityDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(Capability capability) {
        this.capabilityDao.save(capability);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addForJobSeeker(CapabilityForCurriculumVitaeDto capabilityForCurriculumVitaeDto) {
        Capability capability = modelMapper.map(capabilityForCurriculumVitaeDto, Capability.class);

        this.capabilityDao.save(capability);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
