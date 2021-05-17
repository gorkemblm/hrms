package com.gorkem.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "corporate_users")
@PrimaryKeyJoinColumn(name = "corporate_user_id")
public class CorporateUser extends User {

    @Column(name = "company_name", nullable = false, length = 255)
    private String companyName;
    @Column(name = "web_site", nullable = false, length = 255)
    private String website;
    @Column(name = "approve_status", nullable = false)
    private boolean approveStatus;
}
