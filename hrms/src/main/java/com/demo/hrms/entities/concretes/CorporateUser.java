package com.demo.hrms.entities.concretes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="corporate_users")
@EqualsAndHashCode(callSuper = false)
public class CorporateUser extends User{

    private String companyName;
    private String webSite;
    private boolean approveStatus;

    public CorporateUser(){

    }
    public CorporateUser(String companyName, String webSite, boolean approveStatus) {

        this.companyName = companyName;
        this.webSite = webSite;
        this.approveStatus = approveStatus;
    }
}
