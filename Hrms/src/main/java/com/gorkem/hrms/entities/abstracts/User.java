package com.gorkem.hrms.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorkem.hrms.entities.concretes.Token;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 2048)
    private String passwordHash;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id", referencedColumnName = "id")
    private Token token;
}
