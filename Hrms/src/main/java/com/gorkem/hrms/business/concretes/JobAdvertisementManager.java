package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CityService;
import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessDataResult;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final EmployerService employerService;
    private final OccupationService occupationService;
    private final CityService cityService;
    private final ModelMapper modelMapper;

    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao
            ,EmployerService employerService
            ,OccupationService occupationService
            ,CityService cityService
            ,ModelMapper modelMapper) {

        this.jobAdvertisementDao = jobAdvertisementDao;
        this.employerService = employerService;
        this.occupationService = occupationService;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findAll());
    }

    @Override
    public Result add(JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto) {
        JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementForEmployerDto, JobAdvertisement.class);

        jobAdvertisement.setNumberOfApplication(0);
        jobAdvertisement.setApproveStatus(false);
        jobAdvertisement.setActive(false);

        this.jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(LocalDate localDate) {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByUpdatedAtAndIsActiveTrue(localDate));
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployerId(int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByEmployerId(id));
    }

    @Override
    public DataResult<JobAdvertisement> updateStatusJobAdvertisement(int id, boolean status) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id);

        jobAdvertisement.setActive(status);

        this.jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessDataResult<>(Messages.updateJobAdvertisementSuccess, jobAdvertisement);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByEmployer_CompanyName(companyName));
    }
}
