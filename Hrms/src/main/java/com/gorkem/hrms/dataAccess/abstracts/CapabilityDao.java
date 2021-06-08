package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.Capability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityDao extends JpaRepository<Capability, Integer> {
}
