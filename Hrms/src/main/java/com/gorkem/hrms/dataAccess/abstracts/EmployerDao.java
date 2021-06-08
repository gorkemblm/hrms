package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer findByEmail(String email);

    Employer findById(int id);
}
