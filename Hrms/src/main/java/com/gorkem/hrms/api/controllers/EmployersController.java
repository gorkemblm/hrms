package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/employers")
public class EmployersController {

    private final EmployerService employerService;

    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/get-all-employers")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/add-employer")//Useless
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }

    @GetMapping("/find-by-id-employer")
    public DataResult<Employer> findById(@RequestParam int id) {
        return this.employerService.findById(id);
    }
}
