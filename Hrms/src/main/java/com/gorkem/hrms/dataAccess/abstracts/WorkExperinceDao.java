package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExperinceDao extends JpaRepository<WorkExperience, Integer> {

    List<WorkExperience> findByCurriculumVitae_JobSeeker_IdOrderByWorkingDescriptionAscFinishedDateDesc(int id);
}
