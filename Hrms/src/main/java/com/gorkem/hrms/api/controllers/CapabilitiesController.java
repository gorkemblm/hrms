package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CapabilityService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.CapabilityForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/capabilities")
public class CapabilitiesController {

    private CapabilityService capabilityService;

    @Autowired
    public CapabilitiesController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @PostMapping("/addForJobSeeker")
    public Result addForJobSeeker(@RequestBody CapabilityForCurriculumVitaeDto capabilityForCurriculumVitaeDto) {
        return this.capabilityService.addForJobSeeker(capabilityForCurriculumVitaeDto);
    }
}
