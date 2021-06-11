package com.gorkem.hrms.core.dataAccess;

import com.gorkem.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByEmailAndPassword(String email, String password);
}
