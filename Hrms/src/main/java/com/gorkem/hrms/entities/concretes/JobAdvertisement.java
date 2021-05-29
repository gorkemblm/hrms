package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "number_of_open_position", nullable = false)
    private int numberOfOpenPosition;

    @Column(name = "number_of_application")
    private int numberOfApplication;

    @JsonIncludeProperties({"companyName"})
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @JsonIncludeProperties({"name"})
    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private Occupation occupation;

    @JsonIncludeProperties({"city"})
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}







