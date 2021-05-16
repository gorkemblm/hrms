package com.demo.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name="occupations")
public class Occupation {
    @Id
    private int id;
    private String name;
    private LocalDate addedAt;
    private LocalDate UpdatedAt;
    private boolean isActive;

    public Occupation(){

    }

    public Occupation(int id, String name, LocalDate addedAt, LocalDate updatedAt, boolean isActive) {
        this.id = id;
        this.name = name;
        this.addedAt = addedAt;
        UpdatedAt = updatedAt;
        this.isActive = isActive;
    }
}
