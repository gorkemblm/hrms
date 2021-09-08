package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getAll() {
        return ResponseEntity.ok(this.jobAdvertisementService.getAll());
    }

    @GetMapping("/find-by-is-active-true-job-advertisement")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByIsActiveTrue() {
        return ResponseEntity.ok(this.jobAdvertisementService.findByIsActiveTrue());
    }

    @GetMapping("/find-by-employer-id")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByEmployerId(@Positive int id) {
        return ResponseEntity.ok(this.jobAdvertisementService.findByEmployerId(id));
    }

    @GetMapping("/find-by-employer-with-companyName")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByEmployer_CompanyName(@RequestParam String companyName) {
        return ResponseEntity.ok(this.jobAdvertisementService.findByEmployer_CompanyName(companyName));
    }

    @PostMapping("/add-job-advertisement-for-employer")
    public ResponseEntity<Result> add(@RequestBody JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto) {
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisementForEmployerDto));
    }

    @GetMapping("/find-by-updated-and-is-active-true")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> findByUpdatedAtAndIsActiveTrue(@RequestBody LocalDate localDate) {
        return ResponseEntity.ok(this.jobAdvertisementService.findByUpdatedAtAndIsActiveTrue(localDate));
    }

    @PutMapping("/update-status-for-job-advertisement")
    public ResponseEntity<DataResult<JobAdvertisement>> updateStatusJobAdvertisement(@Positive @RequestParam int id, @RequestParam boolean status) {
        return ResponseEntity.ok(this.jobAdvertisementService.updateStatusJobAdvertisement(id, status));
    }
}
