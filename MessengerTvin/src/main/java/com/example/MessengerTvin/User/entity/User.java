package com.example.MessengerTvin.User.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="fullName")
    private String fullName;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;
}