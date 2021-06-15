package com.gorkem.hrms.core.adapters;

import com.gorkem.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface BaseImageUploadService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
