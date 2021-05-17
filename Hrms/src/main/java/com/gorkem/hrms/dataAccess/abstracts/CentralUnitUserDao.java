package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.CentralUnitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralUnitUserDao extends JpaRepository<CentralUnitUser, Integer> {
}
