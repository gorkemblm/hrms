package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Occupation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/occupations")
public class OccupationsController {

    private final OccupationService occupationService;

    public OccupationsController(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @GetMapping("/get-all-occupations")
    public ResponseEntity<DataResult<List<Occupation>>> getAll() {
        return ResponseEntity.ok(this.occupationService.getAll());
    }

    @PostMapping("/add-occupation")
    public ResponseEntity<Result> add(@RequestBody Occupation occupation) {
        return ResponseEntity.ok(this.occupationService.add(occupation));
    }

    @GetMapping("/find-by-occupation-id")
    public ResponseEntity<DataResult<Occupation>> findOccupationById(@RequestParam int id) {
        return ResponseEntity.ok(this.occupationService.findOccupationById(id));
    }
}
