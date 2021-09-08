package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CapabilityService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CapabilityForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/capabilities")
public class CapabilitiesController {

    private final CapabilityService capabilityService;

    public CapabilitiesController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @PostMapping("/add-capability-for-job-seeker")
    public ResponseEntity<Result> addForJobSeeker(@RequestBody CapabilityForCurriculumVitaeDto capabilityForCurriculumVitaeDto) {
        var result = this.capabilityService.addForJobSeeker(capabilityForCurriculumVitaeDto);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
