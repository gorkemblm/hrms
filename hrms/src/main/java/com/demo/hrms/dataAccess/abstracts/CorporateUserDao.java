package com.demo.hrms.dataAccess.abstracts;

import com.demo.hrms.entities.concretes.CorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateUserDao extends JpaRepository<CorporateUser, Integer> {

}
