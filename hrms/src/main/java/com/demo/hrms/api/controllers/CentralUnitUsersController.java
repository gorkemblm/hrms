package com.demo.hrms.api.controllers;

import com.demo.hrms.business.abstracts.CentralUnitUserService;
import com.demo.hrms.entities.concretes.CentralUnitUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/centralunitusers")
public class CentralUnitUsersController {

    private CentralUnitUserService centralUnitUserService;

    @Autowired
    public CentralUnitUsersController(CentralUnitUserService centralUnitUserService) {
        this.centralUnitUserService = centralUnitUserService;
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<CentralUnitUser> getAll(){
        return this.centralUnitUserService.getAll();
    }
}
