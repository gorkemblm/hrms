package com.demo.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="corporate_users")
@EqualsAndHashCode(callSuper = false)
public class CorporateUser extends User{

    private String companyName;
    private String webSite;
    private boolean approveStatus;


}
