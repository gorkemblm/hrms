package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CityService;
import com.gorkem.hrms.business.abstracts.EmployerService;
import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import com.gorkem.hrms.entities.dtos.jobAdvertisementDtos.JobAdvertisementForEmployerDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
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
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.jobAdvertisementDao.findAll());
    }

    @Override
    public Result add(JobAdvertisementForEmployerDto jobAdvertisementForEmployerDto) {
        JobAdvertisement value = null;
        JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementForEmployerDto, JobAdvertisement.class);

        jobAdvertisement.setNumberOfApplication(0);
        jobAdvertisement.setApproveStatus(false);
        jobAdvertisement.setActive(false);

        try {
            value = this.jobAdvertisementDao.save(jobAdvertisement);

            if (value.getId() == 0 || value.getEmployer().getId() == 0) {
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
    public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
        List<JobAdvertisement> value = null;

        try {
            value = this.jobAdvertisementDao.findByIsActiveTrue();

            if (value.isEmpty()) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.LIST_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.LIST_FAILED);
        }
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(LocalDate localDate) {
        List<JobAdvertisement> value = null;

        try {
            value = this.jobAdvertisementDao.findByUpdatedAtAndIsActiveTrue(localDate);

            if (value.isEmpty()) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.LIST_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.LIST_FAILED);
        }
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployerId(int id) {
        List<JobAdvertisement> value = null;

        try {
             value = this.jobAdvertisementDao.findByEmployerId(id);

             if (id == 0 || value.isEmpty()) {
                 throw new Exception();
             } else {
                 return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, value);
             }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.LIST_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.LIST_FAILED);
        }
    }

    @Override
    public DataResult<JobAdvertisement> updateStatusJobAdvertisement(int id, boolean status) {
        JobAdvertisement value = null;

        try {
            value = this.jobAdvertisementDao.findById(id);
            value.setActive(status);

            if (id == 0 || value.getId() == 0 || value.getEmployer().getId() == 0) {
                throw new Exception();
            } else {
                this.jobAdvertisementDao.save(value);
                return new SuccessDataResult<>(Messages.UPDATE_JOB_ADVERTISEMENT_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.UPDATE_JOB_ADVERTISEMENT_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.UPDATE_JOB_ADVERTISEMENT_FAILED);
        }
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName) {
        List<JobAdvertisement> value = null;

        try {
            value = this.jobAdvertisementDao.findByEmployer_CompanyName(companyName);

            if (companyName.equals("") || value.isEmpty()) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.ADD_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.ADD_FAILED);
        }
    }
}
