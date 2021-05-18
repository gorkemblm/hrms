package com.gorkem.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "token_description", nullable = false, length = 512)
    private String tokenDescription;

    @OneToOne(mappedBy = "token")
    private User user;


}
