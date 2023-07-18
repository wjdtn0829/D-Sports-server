package com.example.dsprotsserver.domain.community.domain.repository;

import com.example.dsprotsserver.domain.community.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community, Integer> {
    List<Community> findByTitleContaining(String keyword);
}
