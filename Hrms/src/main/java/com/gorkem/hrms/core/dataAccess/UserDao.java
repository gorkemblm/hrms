package com.gorkem.hrms.core.dataAccess;

import com.gorkem.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);
    User findByEmailAndPasswordHash(String email, String password);
}
