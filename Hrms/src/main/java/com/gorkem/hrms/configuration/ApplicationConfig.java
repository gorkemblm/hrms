package com.gorkem.hrms.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "gorkemblm",
            "api_key", "194311365163593",
            "api_secret", "ryNDRQ_c4dCW_25f20kI-lbtV6w")
    );
}
