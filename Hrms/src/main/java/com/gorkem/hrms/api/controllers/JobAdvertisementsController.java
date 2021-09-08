package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/v1/job-advertisements")
public class JobAdvertisementsController {

    private final JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/get-all-job-advertisements")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getAll() {
        var result = this.jobAdvertisementService.getAll();

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-is-active-true-job-advertisement")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByIsActiveTrue() {
        var result = this.jobAdvertisementService.findByIsActiveTrue();

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-employer-id-job-advertisement")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByEmployerId(@Positive int id) {
        var result =this.jobAdvertisementService.findByEmployerId(id);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-employer-with-companyName-job-advertisement")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByEmployer_CompanyName(@RequestParam String companyName) {
        var result = this.jobAdvertisementService.findByEmployer_CompanyName(companyName);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-job-advertisement-for-employer")
    public ResponseEntity<Result> add(@RequestBody JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto) {
        var result = this.jobAdvertisementService.add(jobAdvertisementForEmployerDto);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-updated-and-is-active-true-job-advertisement")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByUpdatedAtAndIsActiveTrue(@RequestBody LocalDate localDate) {
        var result = this.jobAdvertisementService.findByUpdatedAtAndIsActiveTrue(localDate);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-status-for-job-advertisement")
    public ResponseEntity<DataResult<JobAdvertisement>> updateStatusJobAdvertisement(@Positive @RequestParam int id, @RequestParam boolean status) {
        var result = this.jobAdvertisementService.updateStatusJobAdvertisement(id, status);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
