package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {

    List<School> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(int id);
}
