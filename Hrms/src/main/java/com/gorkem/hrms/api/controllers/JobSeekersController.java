package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.JobSeekerService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.JobSeeker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/job-seekers")
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;

    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/get-all-job-seekers")
    public ResponseEntity<DataResult<List<JobSeeker>>> getAll() {
        return ResponseEntity.ok(this.jobSeekerService.getAll());
    }

    @PostMapping("/add-job-seeker")
    public ResponseEntity<Result> add(@RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
    }

    @GetMapping("/find-by-id-job-seeker")
    public ResponseEntity<DataResult<JobSeeker>> findById(@RequestParam int id) {
        return ResponseEntity.ok(this.jobSeekerService.findById(id));
    }
}
