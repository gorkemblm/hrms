package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CurriculumVitaeService;
import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.ErrorResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.SocialMediaAccountDao;
import com.gorkem.hrms.entities.concretes.SocialMediaAccount;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SocialMediaAccountForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
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
        SocialMediaAccount value = null;

        try {
            value = this.socialMediaAccountDao.save(socialMediaAccount);

            if (value.getId() == 0 || value.getCurriculumVitae().getId() == 0 ) {
                throw new Exception();
            } else {
                return new SuccessResult(Messages.ADD_SUCCESSFUL);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorResult(Messages.ADD_FAILED);
        }
    }

    @Override
    public Result addSocialMediaAccountForJobSeeker(SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        SocialMediaAccount socialMediaAccount = modelMapper.map(socialMediaAccountForCurriculumVitaeDto, SocialMediaAccount.class);

        add(socialMediaAccount);

        return new SuccessResult(Messages.ADD_SUCCESSFUL);
    }
}
