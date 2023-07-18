package com.example.dsprotsserver.domain.community.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommunityRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
