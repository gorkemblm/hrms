package com.demo.hrms.dataAccess.abstracts;

import com.demo.hrms.entities.concretes.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationDao extends JpaRepository<Occupation,Integer> {

}
