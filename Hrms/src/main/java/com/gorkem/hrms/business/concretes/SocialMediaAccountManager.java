package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.SocialMediaAccountDao;
import com.gorkem.hrms.entities.concretes.SocialMediaAccount;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SocialMediaAccountForCurriculumVitaeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService {

    private final SocialMediaAccountDao socialMediaAccountDao;
    private final CurriculumVitaeService curriculumVitaeService;
    private final ModelMapper modelMapper;

    public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccountDao, CurriculumVitaeService curriculumVitaeService, ModelMapper modelMapper) {
        this.socialMediaAccountDao = socialMediaAccountDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(SocialMediaAccount socialMediaAccount) {
        this.socialMediaAccountDao.save(socialMediaAccount);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addSocialMediaAccountForJobSeeker(SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        SocialMediaAccount socialMediaAccount = modelMapper.map(socialMediaAccountForCurriculumVitaeDto, SocialMediaAccount.class);

        this.socialMediaAccountDao.save(socialMediaAccount);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
