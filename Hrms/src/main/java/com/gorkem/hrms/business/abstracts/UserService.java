package com.gorkem.hrms.business.abstracts;

import com.gorkem.hrms.entities.concretes.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {


    void delete(int id);

    User get(int id);

    List<User> getMultiple(List<Integer> id);

    List<User> getAll();

    Page<User> getAll(Pageable pageable);//Bilmiyorum
}
