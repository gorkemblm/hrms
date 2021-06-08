package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.core.entities.User;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/add")//Useless
    public Result add(@RequestBody User user) {
        return this.userService.add(user);
    }
}
