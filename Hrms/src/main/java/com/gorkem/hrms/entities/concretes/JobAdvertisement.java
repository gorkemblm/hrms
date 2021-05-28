package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @Column(name = "approve_status")
    private boolean approveStatus;

    @Column(name = "job_description", length = 1024, nullable = false)
    private String jobDescription;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "number_of_open_position", nullable = false)
    private int numberOfOpenPosition;

    @JsonIgnore
    @Column(name = "number_of_application")
    private int numberOfApplication;

    @ManyToOne
    @JoinColumn(name = "employer_id")//employer'ın id sinden join olucak
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private Occupation occupation;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}


//Şehir






