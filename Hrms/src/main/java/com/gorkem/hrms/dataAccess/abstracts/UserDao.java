package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.email = ?1")
    User findByEmailAddress(String email);

}
