package com.example.dsprotsserver.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 4)
    private int number;

    @NotNull
    @Column(length = 10)
    private String name;

    @NotNull
    @Column(length = 20)
    private String accountId;

    @NotNull
    @Column(length = 60)
    private String password;

    @Builder
    public User(int number, String name, String accountId, String password) {
        this.number = number;
        this.name = name;
        this.accountId = accountId;
        this.password = password;
    }
}
