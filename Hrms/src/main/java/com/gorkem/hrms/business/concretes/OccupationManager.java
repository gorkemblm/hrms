package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.OccupationDao;
import com.gorkem.hrms.entities.concretes.Occupation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OccupationManager implements OccupationService {

    private final OccupationDao occupationDao;

    public OccupationManager(OccupationDao occupationDao) {
        this.occupationDao = occupationDao;
    }

    @Override
    public Occupation findByOccupationName(String name) {
        Occupation value = null;

        try {
            value = this.occupationDao.findByOccupationName(name);

            if (name.equals("") || value.getId() == 0) {
                throw new Exception();
            } else {
                return value;
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return null;
        }
    }

    @Override
    public DataResult<List<Occupation>> getAll() {
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.occupationDao.findAll());
    }

    @Override
    public Result add(Occupation occupation) {
        Occupation value = null;

        if (this.occupationDao.findByOccupationName(occupation.getOccupationName()) != null) {
            log.error("CUSTOM MESSAGE : {}. DATA : {}.", Messages.EXIST_RECORD, occupation);
            return new ErrorResult(Messages.EXIST_RECORD);
        } else {
            try {
                value = this.occupationDao.save(occupation);

                if (value.getId() == 0 || value.getOccupationName().equals("")) {
                    throw new Exception();
                } else {
                    return new SuccessResult(Messages.ADD_SUCCESSFUL);
                }
            } catch (Exception e) {
                log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
                return new ErrorResult(Messages.ADD_FAILED);
            }
        }
    }

    @Override
    public DataResult<Occupation> findOccupationById(int id) {
        Occupation value = null;

        try {
            value = this.occupationDao.findOccupationById(id);

            if (id == 0 || value.getId() == 0 || value.getOccupationName().equals("")) {
                throw new Exception();
            } else {
                return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, value);
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.ADD_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.ADD_FAILED, value);
        }
    }
}
