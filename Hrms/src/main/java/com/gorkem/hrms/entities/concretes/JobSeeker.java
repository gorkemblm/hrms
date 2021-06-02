package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorkem.hrms.entities.abstracts.IndividualUser;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "job_seeker_id")
public class JobSeeker extends IndividualUser {

    @JsonIgnore
    @Column(name = "number_of_application")
    private int numberOfApplication;

}
