package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.CorporateUserService;
import com.gorkem.hrms.entities.concretes.CorporateUser;
import com.gorkem.hrms.entities.concretes.dtos.CorporateUserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api/corporateusers")
public class CorporateUsersController {

    private CorporateUserService corporateUserService;

    @Autowired
    public CorporateUsersController(CorporateUserService corporateUserService) {
        this.corporateUserService = corporateUserService;
    }

    @GetMapping
    public List<CorporateUser> getAll() {
        return this.corporateUserService.getAll();
    }

    @PostMapping("/register")
    @ResponseBody
    CorporateUser register(@RequestBody CorporateUserRegisterDto corporateUserRegisterDto) throws NoSuchAlgorithmException {
        return this.corporateUserService.save(corporateUserRegisterDto);
    }
}
