package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getAll();

    Result add(Employer employer);

    Employer findById(int id);
}
