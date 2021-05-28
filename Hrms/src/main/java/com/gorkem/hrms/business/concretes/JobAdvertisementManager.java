package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.JobAdvertisementService;
import com.gorkem.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public List<JobAdvertisement> getAll() {
        return this.jobAdvertisementDao.findAll();
    }
}
