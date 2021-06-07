package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {

    Result add(ImageWithUserDto imageWithUserDto, MultipartFile file);
}
