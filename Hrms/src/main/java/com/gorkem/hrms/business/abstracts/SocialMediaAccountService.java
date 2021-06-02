package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.SocialMediaAccount;
import com.gorkem.hrms.entities.dtos.SocialMediaAccountForCurriculumVitaeDto;

public interface SocialMediaAccountService {

    Result add(SocialMediaAccount socialMediaAccount);

    Result addSocialMediaAccountForJobSeeker(SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto);
}
