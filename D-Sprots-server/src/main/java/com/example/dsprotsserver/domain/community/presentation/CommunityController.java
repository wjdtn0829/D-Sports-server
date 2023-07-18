package com.example.dsprotsserver.domain.community.presentation;

import com.example.dsprotsserver.domain.community.presentation.dto.request.CommunityRequest;
import com.example.dsprotsserver.domain.community.presentation.dto.response.CommunityResponse;
import com.example.dsprotsserver.domain.community.service.CommunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;
    @PostMapping("/community")
    public CommunityResponse save(@Valid @RequestBody CommunityRequest request) {
        return communityService.save(request);
    }

    @DeleteMapping("/community/{community_id}")
    public void delete(@PathVariable int community_id){
        communityService.delete(community_id);
    }

    @GetMapping("/community/{community_id}")
    public CommunityResponse getStudy(@PathVariable int community_id){
        return communityService.getStudy(community_id);
    }
    @GetMapping("/community/list")
    public List<CommunityResponse> communityList(){
        return communityService.communityList();
    }

    @PatchMapping("/community/{community_id}")
    public void editCommunity(@PathVariable int community_id, @Valid @RequestBody CommunityResponse request){
        communityService.editCommunity(community_id, request);
    }

    @GetMapping("/community")
    public List<CommunityResponse> search(@RequestParam("keyword") String keyword){
        return communityService.search(keyword);
    }
}
