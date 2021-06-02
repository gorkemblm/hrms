package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "cover_letter", length = 1024)
    private String coverLetter;

    @OneToOne
    @MapsId
    @JoinColumn(name = "job_seeker_id")
    @JsonIncludeProperties({"id"})
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<School> schools;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> languages;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Capability> capabilities;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<SocialMediaAccount> socialMediaAccounts;
}
