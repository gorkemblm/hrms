package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.CorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateUserDao extends JpaRepository<CorporateUser, Integer> {
}
