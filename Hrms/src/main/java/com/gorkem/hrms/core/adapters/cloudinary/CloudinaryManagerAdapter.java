package com.gorkem.hrms.core.adapters.cloudinary;

import com.cloudinary.utils.ObjectUtils;
import com.gorkem.hrms.core.utilities.results.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import static com.gorkem.hrms.configuration.ApplicationConfig.cloudinary;

@Service
public class CloudinaryManagerAdapter implements CloudinaryService {

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {

        try {

            Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<>(resultMap);

        } catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<>();
    }
}
