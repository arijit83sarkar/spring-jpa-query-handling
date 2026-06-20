package com.raven.spring_jpa_query_handling.repository;

import com.raven.spring_jpa_query_handling.enitty.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
