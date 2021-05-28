package com.gorkem.hrms.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "corporate_user_id")
@Table(name = "corporate_users")
public abstract class CorporateUser extends User {

    @Column(name = "company_name", nullable = false, length = 255)
    private String companyName;

    @Column(name = "web_site", nullable = false, length = 255)
    private String website;

    @Column(name = "phone_number", length = 13, nullable = false)
    private String phoneNumber;

    @JsonIgnore
    @Column(name = "approve_status")
    private boolean approveStatus;
}
