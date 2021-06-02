package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperinceDao extends JpaRepository<WorkExperience, Integer> {
}
