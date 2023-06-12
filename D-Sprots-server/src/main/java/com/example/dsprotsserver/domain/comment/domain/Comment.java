package com.example.dsprotsserver.domain.comment.domain;

import com.example.dsprotsserver.domain.community.domain.Community;
import com.example.dsprotsserver.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @Column
    private String content;
}
