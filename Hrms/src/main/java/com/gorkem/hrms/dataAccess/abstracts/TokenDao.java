package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenDao extends JpaRepository<Token, Integer> {
}
