package com.example.dsprotsserver.domain.vote.service;

import com.example.dsprotsserver.domain.sportsevent.domain.SportsEvent;
import com.example.dsprotsserver.domain.sportsevent.domain.repository.SportsEventRepository;
import com.example.dsprotsserver.domain.sportsevent.presentation.dto.response.SportsEventResponse;
import com.example.dsprotsserver.domain.user.domain.User;
import com.example.dsprotsserver.domain.user.domain.repository.UserRepository;
import com.example.dsprotsserver.domain.user.exception.UserNotFoundException;
import com.example.dsprotsserver.domain.vote.domain.Vote;
import com.example.dsprotsserver.domain.vote.domain.repository.VoteRepository;
import com.example.dsprotsserver.domain.vote.exception.SportsEventNotFoundException;
import com.example.dsprotsserver.domain.vote.exception.VoteConflictException;
import com.example.dsprotsserver.domain.vote.exception.VoteNotFoundException;
import com.example.dsprotsserver.domain.vote.presentation.dto.response.VoteResponse;
import com.example.dsprotsserver.global.security.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final UserRepository userRepository;
    private final SportsEventRepository sportsEventRepository;
    private final VoteRepository voteRepository;

    private boolean isNotAlreadyVote(SportsEvent sportsEvent, User user){
        return voteRepository.findByUserAndSportsEvent(user, sportsEvent).isEmpty();
    }

    @Transactional
    public void insertVote(int sportsEventId){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        SportsEvent sportsEvent = sportsEventRepository.findById(sportsEventId).orElseThrow(SportsEventNotFoundException::new);
        Vote vote = Vote.builder()
                .user(user)
                .sportsEvent(sportsEvent)
                .build();

        if(isNotAlreadyVote(sportsEvent, user)){
            voteRepository.save(vote);
            sportsEvent.setVoteCount(sportsEvent.getVote_count() + 1);
            sportsEventRepository.save(sportsEvent);
        }
        else {
            throw new VoteConflictException();
        }
    }

    @Transactional
    public void deleteVote(int sportsEventId){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        SportsEvent sportsEvent = sportsEventRepository.findById(sportsEventId).orElseThrow(SportsEventNotFoundException::new);
        Vote vote = voteRepository.findByUserAndSportsEvent(user, sportsEvent).orElseThrow(VoteNotFoundException::new);
        voteRepository.delete(vote);

        sportsEvent.setVoteCount(sportsEvent.getVote_count() - 1);
        sportsEventRepository.save(sportsEvent);
    }

    @Transactional
    public List<VoteResponse> voteList(){
        List<Vote> votes = voteRepository.findAll();
        return votes.stream().map(p -> new VoteResponse(
                p.getId(),
                p.getUser())).collect(Collectors.toList());
    }
}