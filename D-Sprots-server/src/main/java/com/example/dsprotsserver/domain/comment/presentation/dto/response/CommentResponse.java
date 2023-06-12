package com.example.dsprotsserver.domain.comment.presentation.dto.response;

import com.example.dsprotsserver.domain.community.domain.Community;
import com.example.dsprotsserver.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommentResponse {
    private int id;
    private String content;
    private User user;
    private Community community;
}
