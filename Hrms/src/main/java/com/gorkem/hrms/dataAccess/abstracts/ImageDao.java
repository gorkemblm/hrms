package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image, Integer> {

}
