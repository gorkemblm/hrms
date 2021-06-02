package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.ImageService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.ImageDao;
import com.gorkem.hrms.entities.concretes.Image;
import com.gorkem.hrms.entities.dtos.ImageWithUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public Result addForUser(ImageWithUserDto imageWithUserDto) {
        Image image = new Image();
        image.setUserId(imageWithUserDto.getUserId());
        image.setImagePath(imageWithUserDto.getImagePath());

        this.imageDao.save(image);
        return new SuccessResult(Messages.successfullyAdded);
    }
}
