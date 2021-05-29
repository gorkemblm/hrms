package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findByIsActiveTrue();

    List<JobAdvertisement> findByUpdatedAtAndIsActiveTrue(LocalDate localDate);

    List<JobAdvertisement> findByEmployerId(int id);

    List<JobAdvertisement> findByEmployer_CompanyName(String companyName);

    JobAdvertisement findById(int id);
}
