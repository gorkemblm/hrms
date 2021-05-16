package com.demo.hrms.api.controllers;

import com.demo.hrms.business.abstracts.OccupationService;
import com.demo.hrms.entities.concretes.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/occupations")
public class OccupationsController {

    private OccupationService occupationService;

    @Autowired
    public OccupationsController(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<Occupation> getAll(){
        return this.occupationService.getAll();
    }
}
