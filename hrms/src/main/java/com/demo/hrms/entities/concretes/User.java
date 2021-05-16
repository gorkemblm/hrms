package com.demo.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    private LocalDate createdAtDate;
    private LocalDate updatedAtDate;
    private boolean isActive;

    public User(){

    }

    public User(int id, String email, String passwordHash,String passwordSalt, LocalDate createdAtDate, LocalDate updatedAtDate, boolean isActive) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.createdAtDate = createdAtDate;
        this.updatedAtDate = updatedAtDate;
        this.isActive = isActive;
    }
}
