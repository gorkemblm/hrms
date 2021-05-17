package com.gorkem.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password_hash", length = 2048, nullable = false)
    private String passwordHash;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @Column(name = "is_active", nullable = true)
    private boolean isActive;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_tokens",
            joinColumns =
                    {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "token_id", referencedColumnName = "id")})
    private Token token;


}
