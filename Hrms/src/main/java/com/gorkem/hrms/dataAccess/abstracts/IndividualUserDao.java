package com.gorkem.hrms.dataAccess.abstracts;

import com.gorkem.hrms.entities.concretes.IndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualUserDao extends JpaRepository<IndividualUser, Integer> {

    @Query("select u from User u where u.email = ?1")//tabloya atılan mail sorgusu
    IndividualUser findByEmailAddress(String email);

}
