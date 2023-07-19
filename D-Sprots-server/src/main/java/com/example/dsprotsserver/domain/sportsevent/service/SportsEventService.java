package com.example.dsprotsserver.domain.sportsevent.service;

import com.example.dsprotsserver.domain.sportsevent.domain.SportsEvent;
import com.example.dsprotsserver.domain.sportsevent.domain.repository.SportsEventRepository;
import com.example.dsprotsserver.domain.sportsevent.presentation.dto.request.SportsEventRequest;
import com.example.dsprotsserver.domain.sportsevent.presentation.dto.response.SportsEventResponse;
import com.example.dsprotsserver.domain.user.domain.User;
import com.example.dsprotsserver.domain.user.domain.repository.UserRepository;
import com.example.dsprotsserver.domain.user.exception.UserNotFoundException;
import com.example.dsprotsserver.global.security.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportsEventService {
    private final UserRepository userRepository;
    private final SportsEventRepository sportsEventRepository;
    @Transactional
    public SportsEventResponse save(SportsEventRequest request) {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        SportsEvent sportsEvent = SportsEvent.builder()
                .title(request.getTitle())
                .user(user)
                .build();

        sportsEventRepository.save(sportsEvent);

        return SportsEventResponse.builder()
                .id(sportsEvent.getId())
                .title(sportsEvent.getTitle())
                .user(sportsEvent.getUser())
                .build();
    }

    @Transactional
    public void delete(int sportsEvent_id){
        sportsEventRepository.deleteById(sportsEvent_id);
    }

    @Transactional
    public List<SportsEventResponse> sportsEventList(){
        List<SportsEvent> sportsEvents = sportsEventRepository.findAll();
        return sportsEvents.stream().map(p -> new SportsEventResponse(
                p.getId(),
                p.getTitle(),
                p.getUser())).collect(Collectors.toList());
    }
}
