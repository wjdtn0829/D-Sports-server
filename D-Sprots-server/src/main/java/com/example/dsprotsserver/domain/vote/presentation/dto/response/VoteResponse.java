package com.example.dsprotsserver.domain.vote.presentation.dto.response;

import com.example.dsprotsserver.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class VoteResponse {
    private int id;
    private User user;
}