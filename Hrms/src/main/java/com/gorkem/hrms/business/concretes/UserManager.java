package com.gorkem.hrms.business.concretes;

import com.gorkem.hrms.business.abstracts.UserService;
import com.gorkem.hrms.business.constants.Messages;
import com.gorkem.hrms.core.dataAccess.UserDao;
import com.gorkem.hrms.core.entities.User;
import com.gorkem.hrms.core.utilities.results.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(Messages.LIST_SUCCESSFUL, this.userDao.findAll());
    }

    @Override
    public Result add(User user) {
        User value = null;

        try {
            value = this.userDao.save(user);

            if (value.getId() == 0 || value.getEmail().equals("")) {
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
    public DataResult<User> findById(int id) {
        User value = null;

        try {
             value = this.userDao.findById(id);

             if (id == 0 || value.getId() == 0) {
                 throw  new Exception();
             } else {
                 return new SuccessDataResult<>(Messages.FIND_SUCCESSFUL, value);
             }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return new ErrorDataResult<>(Messages.FIND_FAILED, value);
        }
    }

    @Override
    public boolean findByEmailAndPassword(String email, String password) {
        User value = null;

        try {
            if (email.equals("") || password.equals("")) {
                return false;
            } else {
                value = this.userDao.findByEmailAndPassword(email, password);

                if (value.getId() == 0) {
                    throw new Exception();
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("CUSTOM MESSAGE : {}. EXCEPTION MESSAGE : {}. DATA : {}.", Messages.FIND_FAILED, e.getMessage(), value);
            return false;
        }
    }
}
