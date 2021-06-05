package com.gorkem.hrms.configurations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryConfig {

    public static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "gorkemblm",
            "api_key", "194311365163593",
            "api_secret", "ryNDRQ_c4dCW_25f20kI-lbtV6w"));
}
