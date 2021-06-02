package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;

public interface ImageService {

    Result addForUser(ImageWithUserDto imageWithUserDto);
}
