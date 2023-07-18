package com.example.dsprotsserver.domain.comment.domain.repository;

import com.example.dsprotsserver.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
