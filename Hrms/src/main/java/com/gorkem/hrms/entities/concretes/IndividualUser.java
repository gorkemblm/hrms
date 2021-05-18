package com.gorkem.hrms.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(name = "individual_users")
@PrimaryKeyJoinColumn(name = "individual_user_id")
public class IndividualUser extends User {

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "identity_number", length = 11, nullable = false, unique = true)
    private String identityNumber;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

}
