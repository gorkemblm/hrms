package com.gorkem.hrms.core.adapters.cloudinary;

import com.gorkem.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
