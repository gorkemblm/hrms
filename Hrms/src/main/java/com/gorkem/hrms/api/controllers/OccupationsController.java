package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Occupation;
import org.springframework.http.HttpStatus;
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
        var result = this.occupationService.getAll();

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-occupation")
    public ResponseEntity<Result> add(@RequestBody Occupation occupation) {
        var result = this.occupationService.add(occupation);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-occupation-id-occupation")
    public ResponseEntity<DataResult<Occupation>> findOccupationById(@RequestParam int id) {
        var result = this.occupationService.findOccupationById(id);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
