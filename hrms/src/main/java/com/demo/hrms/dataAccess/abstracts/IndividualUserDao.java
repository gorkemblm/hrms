package com.demo.hrms.dataAccess.abstracts;

import com.demo.hrms.entities.concretes.IndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualUserDao extends JpaRepository<IndividualUser, Integer> {
}
