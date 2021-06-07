package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Company name cannot be empty")
    @Size(max = 256, message = "Company name cannot exceed 255 characters")
    @Column(name = "company_name", length = 256, nullable = false)
    private String companyName;

    @NotBlank(message = "Position cannot be empty")
    @Size(max = 128, message = "Position name cannot exceed 128 characters")
    @Column(name = "position", length = 128, nullable = false)
    private String position;

    @PastOrPresent
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
