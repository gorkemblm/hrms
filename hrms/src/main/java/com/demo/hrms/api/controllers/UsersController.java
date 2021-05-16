package com.demo.hrms.api.controllers;

import com.demo.hrms.business.abstracts.UserService;
import com.demo.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;
    LocalDate localDate;


    @Autowired
    public void UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<User> getById(@PathVariable int id){//Parametre belirlemediğimizde requiered ile null dönüyor.
        return this.userService.getById(id);
    }

    @GetMapping("/list/{id}")
    @ResponseBody
    public List<User> getByIds(@PathVariable List<Integer> id){
        return this.userService.getByIds(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<User> getAll(){
        return this.userService.getAll();
    }
    /*@GetMapping("/search")
    @ResponseBody
    public Optional<User> search(@RequestParam String email){
        return this.userService.search(email);
    }*/
}
