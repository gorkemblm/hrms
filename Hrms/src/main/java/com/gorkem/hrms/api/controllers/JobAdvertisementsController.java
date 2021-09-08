package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/job-advertisements")
public class JobAdvertisementsController {

    private final JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/get-all-job-advertisements")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/find-by-is-active-true-job-advertisement")
    public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
        return this.jobAdvertisementService.findByIsActiveTrue();
    }

    @GetMapping("/find-by-employer-id")
    public DataResult<List<JobAdvertisement>> findByEmployerId(@Positive int id) {
        return this.jobAdvertisementService.findByEmployerId(id);
    }

    @GetMapping("/find-by-employer-with-companyName")
    public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(@RequestParam String companyName) {
        return this.jobAdvertisementService.findByEmployer_CompanyName(companyName);
    }

    @PostMapping("/add-job-advertisement-for-employer")
    public Result add(@RequestBody JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto) {
        return this.jobAdvertisementService.add(jobAdvertisementForEmployerDto);
    }

    @GetMapping("/find-by-updated-and-is-active-true")
    public DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(@RequestBody LocalDate localDate) {
        return this.jobAdvertisementService.findByUpdatedAtAndIsActiveTrue(localDate);
    }

    @PutMapping("/update-status-for-job-advertisement")
    public DataResult<JobAdvertisement> updateStatusJobAdvertisement(@Positive @RequestParam int id, @RequestParam boolean status) {
        return this.jobAdvertisementService.updateStatusJobAdvertisement(id, status);
    }
}
