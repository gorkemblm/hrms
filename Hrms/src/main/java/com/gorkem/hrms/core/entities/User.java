package com.gorkem.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorkem.hrms.entities.concretes.Image;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //regex eklenebilir!
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 2048)
    private String passwordHash;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id", referencedColumnName = "id")
    private Token token;*/

    @OneToOne(mappedBy = "user")
    private Image image;
}
