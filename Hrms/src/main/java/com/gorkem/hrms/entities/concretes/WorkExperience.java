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
@Table(name = "work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name", length = 256, nullable = false)
    private String companyName;

    @Column(name = "position", length = 128, nullable = false)
    private String position;

    @Column(name = "started_date", nullable = false)
    private LocalDate startedDate;

    @Column(name = "finished_date")
    private LocalDate finishedDate;

    @Column(name = "is_still_work", nullable = false)
    private boolean isStillWork;

    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;
}
