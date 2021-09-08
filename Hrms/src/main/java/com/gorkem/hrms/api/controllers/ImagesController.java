package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.ImageService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/images")
public class ImagesController {

    private final ImageService imageService;

    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add-image")
    public Result add(@ModelAttribute ImageWithUserDto imageWithUserDto, MultipartFile file) {

        return this.imageService.add(imageWithUserDto, file);
    }
}
