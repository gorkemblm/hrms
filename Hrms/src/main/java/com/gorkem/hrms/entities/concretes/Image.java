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
    @Column(name = "user_id")
    private int userId;

    @JsonIgnore
    @Column(name = "added_at")
    private LocalDate addedAt = LocalDate.now();

    @Column(name = "image_path", length = 1024)
    private String imagePath;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
