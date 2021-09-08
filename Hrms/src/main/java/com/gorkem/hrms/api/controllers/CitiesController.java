package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CityService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/cities")
public class CitiesController {

    private final CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add-city")
    public ResponseEntity<Result> add(@RequestBody City city) {
        return ResponseEntity.ok(this.cityService.add(city));
    }
}
