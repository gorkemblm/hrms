package com.demo.hrms.business.abstracts;

import com.demo.hrms.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getById(int id);
    List<User> getByIds(List<Integer> id);
    //Optional<User> search(String email);
}
