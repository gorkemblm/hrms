package com.gorkem.hrms.business.abstracts;


import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.CoverLetterForCurriculumVitaeDto;

import java.util.List;

public interface CurriculumVitaeService {

    Result addCoverLetterForJobSeeker(CoverLetterForCurriculumVitaeDto coverLetterForCurriculumVitaeDto);

    CurriculumVitae findById(int id);

    DataResult<List<CurriculumVitae>> getAll();
}
