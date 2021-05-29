package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorkem.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value", length = 2048, unique = true, nullable = false)
    private String value;

    @Column(name = "created_at")
    private LocalDate createdDate;

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDate updatedDate;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(mappedBy = "token")
    private User user;
}
