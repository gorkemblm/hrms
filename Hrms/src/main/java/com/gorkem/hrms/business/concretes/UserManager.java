package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.core.utils.security.PasswordHash;
import com.gorkem.hrms.dataAccess.abstracts.UserDao;
import com.gorkem.hrms.entities.concretes.User;
import com.gorkem.hrms.entities.concretes.dtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(UserRegisterDto userRegisterDto) throws NoSuchAlgorithmException {

        final String passwordHash = PasswordHash.generateHash(userRegisterDto.getPassword());

        User user = new User();

        user.setEmail(userRegisterDto.getEmail());
        user.setPasswordHash(passwordHash);
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());
        user.setActive(true);

        User finalUser = userDao.save(user);

        return finalUser;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getMultiple(List<Integer> id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return null;
    }
}
