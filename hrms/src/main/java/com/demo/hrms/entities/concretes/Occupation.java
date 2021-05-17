package com.demo.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="occupations")
public class Occupation {
    @Id
    private int id;
    private String name;
    private LocalDate addedAt;
    private LocalDate UpdatedAt;
    private boolean isActive;


}
