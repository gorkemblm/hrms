package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.SocialMediaAccountDao;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.concretes.SocialMediaAccount;
import com.gorkem.hrms.entities.dtos.SocialMediaAccountForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService {

    private SocialMediaAccountDao socialMediaAccountDao;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccountDao, CurriculumVitaeService curriculumVitaeService) {
        this.socialMediaAccountDao = socialMediaAccountDao;
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @Override
    public Result add(SocialMediaAccount socialMediaAccount) {
        this.socialMediaAccountDao.save(socialMediaAccount);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public Result addSocialMediaAccountForJobSeeker(SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        SocialMediaAccount socialMediaAccount = new SocialMediaAccount();

        socialMediaAccount.setCurriculumVitae(this.curriculumVitaeService.findById(socialMediaAccountForCurriculumVitaeDto.getCurriculumVitaeId()));

        socialMediaAccount.setType(socialMediaAccountForCurriculumVitaeDto.getType());
        socialMediaAccount.setUrl(socialMediaAccountForCurriculumVitaeDto.getUrl());


        this.socialMediaAccountDao.save(socialMediaAccount);

        return new SuccessResult(Messages.successfullyAdded);
    }
}
