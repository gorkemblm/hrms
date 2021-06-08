package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaAccountDao extends JpaRepository<SocialMediaAccount, Integer> {
}
