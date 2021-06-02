package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {
}
