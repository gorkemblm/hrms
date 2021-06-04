package com.gorkem.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorkem.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @Column(name = "added_at")
    private LocalDate addedAt = LocalDate.now();

    @Column(name = "url",length = 256)
    private String url;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id",unique = true)
    private User user;
}
