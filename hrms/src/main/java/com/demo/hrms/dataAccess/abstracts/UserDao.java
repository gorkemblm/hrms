package com.demo.hrms.dataAccess.abstracts;

import com.demo.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    /*@Query(value = "SELECT c FROM User c WHERE c.name LIKE '%' HAVING :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'")*/
    //Optional<User> search(@Param("email") String email);
}
