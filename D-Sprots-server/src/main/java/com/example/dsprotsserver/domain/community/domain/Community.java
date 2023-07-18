package com.example.dsprotsserver.domain.community.domain;

import com.example.dsprotsserver.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Builder
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Community(Integer id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void editCommunity(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
