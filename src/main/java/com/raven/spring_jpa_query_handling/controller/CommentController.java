package com.raven.spring_jpa_query_handling.controller;

import com.raven.spring_jpa_query_handling.enitty.Comment;
import com.raven.spring_jpa_query_handling.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
@Tag(name = "Comment", description = "APIs for managing comments on a post")
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @Operation(summary = "Get all comments for a post")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        log.info("GET /posts/{}/comments - fetching comments", postId);
        return commentService.findByPostId(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a comment to a post")
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        log.info("POST /posts/{}/comments - adding comment", postId);
        return commentService.addComment(postId, comment);
    }
}