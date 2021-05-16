package com.demo.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="central_unit_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class CentralUnitUser extends User{

    private char gender;
    private String firstName;
    private String lastName;

    public CentralUnitUser(){

    }

    public CentralUnitUser(char gender, String firstName, String lastName) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
