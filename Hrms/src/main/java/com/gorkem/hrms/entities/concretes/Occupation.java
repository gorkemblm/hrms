package com.gorkem.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "occupations")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description", nullable = false, length = 1024)
    private String description;
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "update_at", nullable = false)
    private LocalDate updatedAt;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;


}
