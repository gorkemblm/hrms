package com.gorkem.hrms.entities.concretes;

import com.gorkem.hrms.entities.abstracts.IndividualUser;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "company_employees")
@PrimaryKeyJoinColumn(name = "company_employee_id")
public class CompanyEmployee extends IndividualUser {

}
