package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto);

    DataResult<List<JobAdvertisement>> findByIsActiveTrue();

    DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(LocalDate localDate);

    DataResult<List<JobAdvertisement>> findByEmployerId(int id);

    DataResult<JobAdvertisement> updateStatusJobAdvertisement(int id, boolean status);

    DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName);
}
