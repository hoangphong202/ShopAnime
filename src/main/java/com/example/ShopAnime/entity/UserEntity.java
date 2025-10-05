package com.example.ShopAnime.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name", nullable = false, unique = true, length = 50)
    private String Name;

    @Column(name="email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name="phone", nullable = false, unique = true, length = 50)
    private int phone;

    @OneToOne
    @JoinColumn(name = "accountEntity_id", referencedColumnName = "id")
    private AccountEntity accountEntity;
}
