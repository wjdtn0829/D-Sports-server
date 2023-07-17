package com.example.dsprotsserver.domain.vote.presentation;

import com.example.dsprotsserver.domain.vote.presentation.dto.response.VoteResponse;
import com.example.dsprotsserver.domain.vote.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/vote/{sportsEvent_id}")
    @Operation(summary = "투표 추가")
    public void insertGood(@PathVariable int sportsEvent_id){
        voteService.insertVote(sportsEvent_id);
    }

    @DeleteMapping("/vote/{sportsEvent_id}")
    @Operation(summary = "투표 삭제")
    public void deleteGood(@PathVariable int sportsEvent_id){
        voteService.deleteVote(sportsEvent_id);
    }

    @GetMapping("/vote/list")
    public List<VoteResponse> voteList(){
        return voteService.voteList();
    }
}