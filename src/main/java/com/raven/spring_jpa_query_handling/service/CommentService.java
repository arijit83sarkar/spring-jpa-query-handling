package com.raven.spring_jpa_query_handling.service;

import com.raven.spring_jpa_query_handling.enitty.Comment;
import com.raven.spring_jpa_query_handling.enitty.Post;
import com.raven.spring_jpa_query_handling.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private static final Logger log = LoggerFactory.getLogger(CommentService.class);

    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public Comment addComment(Long postId, Comment comment) {
        log.info("Adding comment to post id: {}", postId);
        Post post = postService.findById(postId);
        comment.setPost(post);
        Comment saved = commentRepository.save(comment);
        log.debug("Comment saved with id: {}", saved.getId());
        return saved;
    }
}