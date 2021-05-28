package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gorkem.hrms.entities.abstracts.CorporateUser;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employer_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Employer extends CorporateUser {

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

}
