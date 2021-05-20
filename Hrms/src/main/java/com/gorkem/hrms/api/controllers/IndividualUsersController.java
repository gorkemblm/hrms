package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.IndividualUserService;
import com.gorkem.hrms.entities.concretes.IndividualUser;
import com.gorkem.hrms.entities.concretes.dtos.IndividualUserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/individualusers")
public class IndividualUsersController {

    private IndividualUserService individualUserService;

    @Autowired
    public IndividualUsersController(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

    @GetMapping
    @ResponseBody
    public List<IndividualUser> getAll() {
        return this.individualUserService.getAll();
    }

    @PostMapping("/register")
    @ResponseBody
    public IndividualUser register(@RequestBody IndividualUserRegisterDto individualUserRegisterDto) throws Exception {
        return this.individualUserService.save(individualUserRegisterDto);
    }


}
