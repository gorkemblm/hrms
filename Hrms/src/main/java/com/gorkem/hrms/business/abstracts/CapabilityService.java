package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Capability;
import com.gorkem.hrms.entities.dtos.CapabilityForCurriculumVitaeDto;

public interface CapabilityService {

    Result add(Capability capability);

    Result addForJobSeeker(CapabilityForCurriculumVitaeDto capabilityForCurriculumVitaeDto);
}
