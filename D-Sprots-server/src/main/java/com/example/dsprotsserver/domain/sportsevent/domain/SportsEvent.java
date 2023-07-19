package com.example.dsprotsserver.domain.sportsevent.domain;

import com.example.dsprotsserver.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Builder
public class SportsEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private int vote_count;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setVoteCount(int voteCount){
        this.vote_count = voteCount;
    }
    public SportsEvent(Integer id, String title, int vote_count, User user) {
        this.id = id;
        this.title = title;
        this.vote_count = vote_count;
        this.user = user;
    }
}
