package com.example.dsprotsserver.domain.community.service;

import com.example.dsprotsserver.domain.community.domain.Community;
import com.example.dsprotsserver.domain.community.domain.repository.CommunityRepository;
import com.example.dsprotsserver.domain.community.exception.CommunityNotFoundException;
import com.example.dsprotsserver.domain.community.presentation.dto.request.CommunityRequest;
import com.example.dsprotsserver.domain.community.presentation.dto.response.CommunityResponse;
import com.example.dsprotsserver.domain.user.domain.User;
import com.example.dsprotsserver.domain.user.domain.repository.UserRepository;
import com.example.dsprotsserver.domain.user.exception.UserNotFoundException;
import com.example.dsprotsserver.global.security.SecurityUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;

    @Transactional
    public CommunityResponse save(CommunityRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Community community = Community.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .build();

        communityRepository.save(community);

        return CommunityResponse.builder()
                .id(community.getId())
                .title(community.getTitle())
                .content(community.getContent())
                .user(community.getUser())
                .build();
    }

    @Transactional
    public void delete(int community_id){
        communityRepository.deleteById(community_id);
    }

    @Transactional
    public CommunityResponse getStudy(int community_id){
        Community community = communityRepository.findById(community_id).orElseThrow(CommunityNotFoundException::new);
        return CommunityResponse.builder()
                .id(community.getId())
                .title(community.getTitle())
                .content(community.getContent())
                .user(community.getUser())
                .build();
    }

    @Transactional
    public List<CommunityResponse> communityList(){
        List<Community> communities = communityRepository.findAll();
        return communities.stream().map(p -> new CommunityResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getUser())).collect(Collectors.toList());
    }

    @Transactional
    public void editCommunity(int community_id, @Valid CommunityResponse request){
        Community community = communityRepository.findById(community_id).orElseThrow(CommunityNotFoundException::new);
        community.editCommunity(request.getTitle(), request.getContent());
        communityRepository.save(community);
    }

    @Transactional
    public List<CommunityResponse> search(String keyword){
        List<Community> communities = communityRepository.findByTitleContaining(keyword);
        return communities.stream().map(p -> new CommunityResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getUser())).collect(Collectors.toList());
    }
}
