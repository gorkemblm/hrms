package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisement> getAll();
}
