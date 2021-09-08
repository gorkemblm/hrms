package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.OccupationService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.utilities.results.*;
import com.gorkem.hrms.dataAccess.abstracts.OccupationDao;
import com.gorkem.hrms.entities.concretes.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationManager implements OccupationService {

    private final OccupationDao occupationDao;

    public OccupationManager(OccupationDao occupationDao) {
        this.occupationDao = occupationDao;
    }

    @Override
    public Occupation findByOccupationName(String name) {
        return this.occupationDao.findByOccupationName(name);
    }

    @Override
    public DataResult<List<Occupation>> getAll() {
        return new SuccessDataResult<List<Occupation>>(Messages.successfullyListed, this.occupationDao.findAll());
    }

    @Override
    public Result add(Occupation occupation) {
        if (this.occupationDao.findByOccupationName(occupation.getOccupationName()) != null) {
            return new ErrorResult(Messages.existInRecords);
        } else {
            this.occupationDao.save(occupation);
            return new SuccessResult(Messages.successfullyAdded);
        }
    }

    @Override
    public DataResult<Occupation> findOccupationById(int id) {
        return new SuccessDataResult<>(Messages.successfullyListed, this.occupationDao.findOccupationById(id));
    }
}
