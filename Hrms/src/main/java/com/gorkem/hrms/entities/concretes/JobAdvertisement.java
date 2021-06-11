package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @Column(name = "approve_status")
    private boolean approveStatus;

    @JsonIgnore
    @Size(max = 1200, message = "Description cannot exceed 1200 characters")
    @Column(name = "job_description", length = 1200, nullable = false)
    private String jobDescription;

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Future
    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @NotNull(message = "Number of open position cannot be empty")
    @Positive
    @Column(name = "number_of_open_position", nullable = false)
    private int numberOfOpenPosition;

    @Positive
    @Column(name = "number_of_application")
    private int numberOfApplication;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    @JsonIncludeProperties({"companyName"})
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    @JsonIncludeProperties({"name"})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Occupation occupation;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIncludeProperties({"city"})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private City city;
}







