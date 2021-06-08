package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.City;

public interface CityService {
    Result add(City city);

    City findByCity(String city);
}
