package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.ImageService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/v1/images")
public class ImagesController {

    private final ImageService imageService;

    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add-image")
    public ResponseEntity<Result> add(@ModelAttribute ImageWithUserDto imageWithUserDto, MultipartFile file) {
        var result = this.imageService.add(imageWithUserDto, file);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
