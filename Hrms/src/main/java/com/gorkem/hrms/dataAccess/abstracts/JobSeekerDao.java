package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    JobSeeker findByEmail(String email);

    JobSeeker findByIdentityNumber(String identityNumber);

    JobSeeker findById(int id);//For CV
}
