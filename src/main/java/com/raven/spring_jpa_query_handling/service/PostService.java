package com.raven.spring_jpa_query_handling.service;

import com.raven.spring_jpa_query_handling.enitty.Post;
import com.raven.spring_jpa_query_handling.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        log.info("Saving post with title: {}", post.getTitle());
        Post saved = postRepository.save(post);
        log.debug("Post saved with id: {}", saved.getId());
        return saved;
    }

    public Post findById(Long id) {
        log.debug("Fetching post with id: {}", id);
        return postRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Post not found with id: {}", id);
                    return new RuntimeException("Post not found with id: " + id);
                });
    }
}
