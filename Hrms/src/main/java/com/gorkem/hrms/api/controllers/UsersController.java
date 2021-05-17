package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.entities.concretes.User;
import com.gorkem.hrms.entities.concretes.dtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseBody
    public User save(@RequestBody UserRegisterDto userRegisterDto) throws NoSuchAlgorithmException {
        return userService.save(userRegisterDto);
    }

    @GetMapping
    @ResponseBody
    public List<User> getAll() {
        return this.userService.getAll();
    }
}
