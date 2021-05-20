package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.dataAccess.abstracts.UserDao;
import com.gorkem.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User findByEmailAddress(String email) {
        return this.userDao.findByEmailAddress(email);
    }
}
