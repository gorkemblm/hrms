package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

    City findByCityName(String city);
}
