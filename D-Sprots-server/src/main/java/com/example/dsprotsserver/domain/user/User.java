package com.example.dsprotsserver.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    @Column(length = 20)
    private String password;

}
