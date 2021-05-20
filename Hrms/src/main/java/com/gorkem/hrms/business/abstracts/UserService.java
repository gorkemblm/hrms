package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findByEmailAddress(String email);

}
