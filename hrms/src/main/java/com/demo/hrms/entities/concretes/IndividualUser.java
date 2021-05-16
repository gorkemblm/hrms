package com.demo.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="individual_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class IndividualUser extends User{

    private char gender;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private LocalDate dateOfBirth;

    public IndividualUser(){

    }

    public IndividualUser(char gender, String firstName, String lastName, String identityNumber, LocalDate dateOfBirth) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
