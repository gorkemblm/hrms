package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.core.entities.User;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all-users")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/add-user")//Useless
    public Result add(@RequestBody User user) {
        return this.userService.add(user);
    }

    @GetMapping("/find-by-id-user")
    public DataResult<User> findById(@RequestParam int id) {
        return this.userService.findById(id);
    }
}
