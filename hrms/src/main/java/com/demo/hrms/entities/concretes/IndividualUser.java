package com.demo.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="individual_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class IndividualUser extends User{

    private char gender;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private LocalDate dateOfBirth;


}
