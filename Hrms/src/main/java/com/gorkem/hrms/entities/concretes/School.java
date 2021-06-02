package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name", length = 256, nullable = false)
    private String schoolName;

    @Column(name = "department", length = 128, nullable = false)
    private String department;

    @Column(name = "started_date", nullable = false)
    private LocalDate startedDate;

    @Column(name = "finished_date")
    private LocalDate finishedDate;

    @Column(name = "graduation_status", nullable = false)
    private boolean graduationStatus;

    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;
}
