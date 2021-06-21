package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/findByIsActiveTrue")
    public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
        return this.jobAdvertisementService.findByIsActiveTrue();
    }

    @GetMapping("/findByEmployerId")
    public DataResult<List<JobAdvertisement>> findByEmployerId(@Positive int id) {
        return this.jobAdvertisementService.findByEmployerId(id);
    }

    @GetMapping("/findByEmployer_CompanyName")
    public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(@RequestParam String companyName) {
        return this.jobAdvertisementService.findByEmployer_CompanyName(companyName);
    }

    @PostMapping("/addJobAdvertisementForEmployer")
    public Result add(@RequestBody JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto) {
        return this.jobAdvertisementService.add(jobAdvertisementForEmployerDto);
    }

    @GetMapping("/findByUpdatedAtAndIsActiveTrue")
    public DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(@RequestBody LocalDate localDate) {
        return this.jobAdvertisementService.findByUpdatedAtAndIsActiveTrue(localDate);
    }

    @PutMapping("/updateStatusJobAdvertisement")
    public DataResult<JobAdvertisement> updateStatusJobAdvertisement(@Positive @RequestParam int id, @RequestParam boolean status) {
        return this.jobAdvertisementService.updateStatusJobAdvertisement(id, status);
    }
}
