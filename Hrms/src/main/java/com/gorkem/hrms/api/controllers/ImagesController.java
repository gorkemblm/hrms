package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.ImageService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/addForUser")
    public Result addForUser(@RequestBody ImageWithUserDto imageWithUserDto) {
        return this.imageService.addForUser(imageWithUserDto);
    }
}
