package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.ImageService;
import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.adapters.BaseImageUploadService;
import com.gorkem.hrms.core.utilities.results.ErrorResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.ImageDao;
import com.gorkem.hrms.entities.concretes.Image;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
@Service
public class ImageManager implements ImageService {

    private final ImageDao imageDao;
    private final BaseImageUploadService baseImageUploadService;
    private final UserService userService;

    public ImageManager(ImageDao imageDao, BaseImageUploadService baseImageUploadService, UserService userService) {
        this.imageDao = imageDao;
        this.baseImageUploadService = baseImageUploadService;
        this.userService = userService;
    }

    @Override
    public Result add(ImageWithUserDto imageWithUserDto, MultipartFile file) {
        Image value = null;

        Image image = new Image();

        image.setUser(this.userService.findById(imageWithUserDto.getUserId()).getData());

        Map<String, String> uploadImage = this.baseImageUploadService.uploadImageFile(file).getData();

        image.setUrl(uploadImage.get("url"));

        try {
            value = this.imageDao.save(image);

            if (value.getId() == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorResult(Messages.ADD_FAILED);
        }
        return new SuccessResult(Messages.ADD_SUCCESSFUL);
    }
}
