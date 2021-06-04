package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.ImageService;
import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.adapters.cloudinary.CloudinaryService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.ImageDao;
import com.gorkem.hrms.entities.concretes.Image;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private CloudinaryService cloudinaryService;
    private UserService userService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService, UserService userService) {
        this.imageDao = imageDao;
        this.cloudinaryService = cloudinaryService;
        this.userService = userService;
    }

    @Override
    public Result add(ImageWithUserDto imageWithUserDto, MultipartFile file) {

        Image image = new Image();

        image.setUser(this.userService.findById(imageWithUserDto.getUserId()));

        Map<String, String> uploadImage = this.cloudinaryService.uploadImageFile(file).getData();

        image.setUrl(uploadImage.get("url"));

        this.imageDao.save(image);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
