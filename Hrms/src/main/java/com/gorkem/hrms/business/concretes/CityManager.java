package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.CityService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.ErrorResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.core.utilities.results.SuccessResult;
import com.gorkem.hrms.dataAccess.abstracts.CityDao;
import com.gorkem.hrms.entities.concretes.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CityManager implements CityService {

    private final CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        City value = null;

        try {
            value = this.cityDao.save(city);

            if (value.getId() == 0 || value.getCityName().equals("")) {
                throw new Exception();
            } else {
                return new SuccessResult(Messages.ADD_SUCCESSFUL);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorResult(Messages.ADD_FAILED);
        }
    }

    @Override
    public City findByCityName(String city) {
        City value = null;

        try {
            value = this.cityDao.findByCityName(city);

            if (value.getId() == 0 || value.getCityName().equals("")) {
                throw new Exception();
            } else {
                return value;
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return null;
        }
    }
}
