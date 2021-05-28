package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

}
