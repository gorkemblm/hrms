package com.gorkem.hrms.entities.abstracts;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "individual_users")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "individual_user_id")
public abstract class IndividualUser extends User {

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "identity_number", length = 11, nullable = false, unique = true)
    private String identityNumber;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

}
