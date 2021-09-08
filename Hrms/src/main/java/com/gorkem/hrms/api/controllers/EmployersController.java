package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Employer;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<Employer>>> getAll() {
        return ResponseEntity.ok(this.employerService.getAll());
    }

    @PostMapping("/add-employer")//Useless
    public ResponseEntity<Result> add(@RequestBody Employer employer) {
        return ResponseEntity.ok(this.employerService.add(employer));
    }

    @GetMapping("/find-by-id-employer")
    public ResponseEntity<DataResult<Employer>> findById(@RequestParam int id) {
        return ResponseEntity.ok(this.employerService.findById(id));
    }
}
