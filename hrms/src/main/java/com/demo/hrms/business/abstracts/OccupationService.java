package com.demo.hrms.business.abstracts;

import com.demo.hrms.entities.concretes.Occupation;

import java.util.List;

public interface OccupationService {

    List<Occupation> getAll();
}
