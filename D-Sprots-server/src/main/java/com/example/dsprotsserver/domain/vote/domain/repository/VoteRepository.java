package com.example.dsprotsserver.domain.vote.domain.repository;

import com.example.dsprotsserver.domain.sportsevent.domain.SportsEvent;
import com.example.dsprotsserver.domain.user.domain.User;
import com.example.dsprotsserver.domain.vote.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Optional<Vote> findByUserAndSportsEvent(User user, SportsEvent sportsEvent);
}
