package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.core.entities.User;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    Result add(User user);

    DataResult<User> findById(int id);

    boolean findByEmailAndPassword(String email, String password);
}
