package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Occupation;

import java.util.List;

public interface OccupationService {

    DataResult<List<Occupation>> getAll();

    Result add(Occupation occupation);

    Occupation findByOccupationName(String name);
}
