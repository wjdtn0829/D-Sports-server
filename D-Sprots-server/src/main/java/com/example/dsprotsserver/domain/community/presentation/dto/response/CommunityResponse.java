package com.example.dsprotsserver.domain.community.presentation.dto.response;

import com.example.dsprotsserver.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommunityResponse {
    private int id;
    private String title;
    private String content;
    private User user;
}
