package com.demo.hrms.business.concretes;

import com.demo.hrms.business.abstracts.UserService;
import com.demo.hrms.dataAccess.abstracts.UserDao;
import com.demo.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getByIds(List<Integer> id) {
        return userDao.findAllById(id);
        userDao.
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }


}
