package com.demo.hrms.business.concretes;

import com.demo.hrms.business.abstracts.OccupationService;
import com.demo.hrms.dataAccess.abstracts.OccupationDao;
import com.demo.hrms.entities.concretes.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OccupationManager implements OccupationService {

    private OccupationDao occupationDao;

    @Autowired
    public OccupationManager(OccupationDao occupationDao) {
        this.occupationDao = occupationDao;
    }

    @Override
    public List<Occupation> getAll() {
        return this.occupationDao.findAll();
    }
}
