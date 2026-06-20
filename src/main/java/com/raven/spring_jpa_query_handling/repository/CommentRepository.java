package com.raven.spring_jpa_query_handling.repository;

import com.raven.spring_jpa_query_handling.enitty.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
