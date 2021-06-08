package com.gorkem.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageWithUserDto {

    private int userId;

    private String url = "https://api.cloudinary.com/v1_1/gorkemblm/image/upload";//??
}
