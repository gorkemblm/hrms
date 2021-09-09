package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CapabilityService;
import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.ErrorResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.CapabilityDao;
import com.gorkem.hrms.entities.concretes.Capability;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CapabilityForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CapabilityManager implements CapabilityService {

    private final CapabilityDao capabilityDao;
    private final CurriculumVitaeService curriculumVitaeService;
    private final ModelMapper modelMapper;

    public CapabilityManager(CapabilityDao capabilityDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.capabilityDao = capabilityDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(Capability capability) {
        Capability value = null;

        try {
            value = this.capabilityDao.save(capability);

            if (value.getId() == 0 || value.getName().equals("")) {
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
    public Result addForJobSeeker(CapabilityForCurriculumVitaeDto capabilityForCurriculumVitaeDto) {
        Capability capability = modelMapper.map(capabilityForCurriculumVitaeDto, Capability.class);

        return add(capability);
    }
}
