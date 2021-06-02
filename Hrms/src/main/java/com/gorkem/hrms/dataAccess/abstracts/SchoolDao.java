package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School, Integer> {

}
