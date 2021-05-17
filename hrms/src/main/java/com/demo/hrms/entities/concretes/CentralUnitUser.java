package com.demo.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="central_unit_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class CentralUnitUser extends User{

    private char gender;
    private String firstName;
    private String lastName;


}
