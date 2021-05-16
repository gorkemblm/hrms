package com.demo.hrms.api.controllers;


import com.demo.hrms.business.abstracts.IndividualUserService;
import com.demo.hrms.entities.concretes.IndividualUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/individualusers")
public class IndividualUsersController {

    private IndividualUserService individualUserService;

    @Autowired
    public IndividualUsersController(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }
    @GetMapping("/getall")
    @ResponseBody
    public List<IndividualUser> getAll(){
        return this.individualUserService.getAll();
    }
}
