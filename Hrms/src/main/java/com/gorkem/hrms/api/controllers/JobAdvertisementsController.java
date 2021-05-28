package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobadvertisement")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public List<JobAdvertisement> getAll() {
        return this.jobAdvertisementService.getAll();
    }
}
