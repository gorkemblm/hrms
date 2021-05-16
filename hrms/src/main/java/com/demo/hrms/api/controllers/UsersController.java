package com.demo.hrms.api.controllers;

import com.demo.hrms.business.abstracts.UserService;
import com.demo.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public void UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/user")
    @ResponseBody
    public Optional<User> getById(@RequestParam int id){//Parametre belirlemediğimizde requiered ile null dönüyor.
        return this.userService.getById(id);
    }
    @GetMapping("/get/users")
    @ResponseBody
    public List<User> getByIds(@RequestParam List<Integer> id){
        return this.userService.getByIds(id);
    }
    @GetMapping("/getall")
    @ResponseBody
    public List<User> getAll(){
        return this.userService.getAll();
    }
}
