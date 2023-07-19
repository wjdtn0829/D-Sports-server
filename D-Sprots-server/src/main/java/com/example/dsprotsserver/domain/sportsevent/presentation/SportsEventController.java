package com.example.dsprotsserver.domain.sportsevent.presentation;

import com.example.dsprotsserver.domain.community.presentation.dto.response.CommunityResponse;
import com.example.dsprotsserver.domain.sportsevent.presentation.dto.request.SportsEventRequest;
import com.example.dsprotsserver.domain.sportsevent.presentation.dto.response.SportsEventResponse;
import com.example.dsprotsserver.domain.sportsevent.service.SportsEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SportsEventController {
    private final SportsEventService sportsEventService;

    @PostMapping("/sportsEvent")
    public SportsEventResponse save(@Valid @RequestBody SportsEventRequest request) {
        return sportsEventService.save(request);
    }

    @DeleteMapping("/sportsEvent/{sportsEvent_id}")
    public void delete(@PathVariable int sportsEvent_id){
        sportsEventService.delete(sportsEvent_id);
    }

    @GetMapping("/sportsEvent/list")
    public List<SportsEventResponse> sportsEventList(){
        return sportsEventService.sportsEventList();
    }
}
