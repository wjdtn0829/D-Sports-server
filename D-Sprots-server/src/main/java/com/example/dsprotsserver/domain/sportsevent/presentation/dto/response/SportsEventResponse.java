package com.example.dsprotsserver.domain.sportsevent.presentation.dto.response;

import com.example.dsprotsserver.domain.community.domain.Community;
import com.example.dsprotsserver.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SportsEventResponse {
    private int id;
    private String title;
    private User user;
}
