package com.raven.spring_jpa_query_handling.controller;

import com.raven.spring_jpa_query_handling.enitty.Post;
import com.raven.spring_jpa_query_handling.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@Tag(name = "Post", description = "APIs for managing posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new post")
    public Post createPost(@RequestBody Post post) {
        log.info("POST /posts - creating post: {}", post.getTitle());
        return postService.save(post);
    }
}