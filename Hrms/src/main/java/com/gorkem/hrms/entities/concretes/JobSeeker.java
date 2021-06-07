package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "job_seeker_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "image"})
public class JobSeeker extends IndividualUser {

    @JsonIgnore
    @Positive
    @Column(name = "number_of_application")
    private int numberOfApplication;

    @OneToOne(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CurriculumVitae curriculumVitae;
}
