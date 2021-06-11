package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/occupations")
public class OccupationsController {

    private OccupationService occupationService;

    @Autowired
    public OccupationsController(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Occupation>> getAll() {
        return this.occupationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Occupation occupation) {
        return this.occupationService.add(occupation);
    }
}
