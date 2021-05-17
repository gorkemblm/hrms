package com.gorkem.hrms.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "central_unit_users")
@PrimaryKeyJoinColumn(name = "central_unit_user_id")
public class CentralUnitUser extends User {
    @Column(name = "gender", nullable = false)
    private char gender;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String LastName;

}
