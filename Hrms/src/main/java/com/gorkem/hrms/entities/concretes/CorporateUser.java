package com.gorkem.hrms.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
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
