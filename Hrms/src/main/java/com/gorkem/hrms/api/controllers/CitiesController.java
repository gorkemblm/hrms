package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CityService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
        var result = this.cityService.add(city);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
