package com.demo.hrms.dataAccess.abstracts;

import com.demo.hrms.entities.concretes.CentralUnitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralUserDao extends JpaRepository<CentralUnitUser, Integer> {
}
