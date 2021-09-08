package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorkem.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Value cannot be empty")
    @Column(name = "value", length = 2048, unique = true, nullable = false)
    private String value;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdDate = LocalDate.now();

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDate updatedDate;

    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive;
}
