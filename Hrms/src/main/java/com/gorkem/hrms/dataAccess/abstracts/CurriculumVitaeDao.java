package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

    CurriculumVitae findById(int id);

    CurriculumVitae findByJobSeeker_Id(int id);
}
