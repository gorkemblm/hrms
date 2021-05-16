package com.demo.hrms.api.controllers;

import com.demo.hrms.business.abstracts.CorporateUserService;
import com.demo.hrms.entities.concretes.CorporateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/corporateusers")
public class CorporateUsersController {

    private CorporateUserService corporateUserService;

    @Autowired
    public CorporateUsersController(CorporateUserService corporateUserService) {
        this.corporateUserService = corporateUserService;
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<CorporateUser> getAll(){
        return this.corporateUserService.getAll();
    }
}
