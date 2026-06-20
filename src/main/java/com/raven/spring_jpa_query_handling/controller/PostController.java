package com.raven.spring_jpa_query_handling.controller;

import com.raven.spring_jpa_query_handling.enitty.Post;
import com.raven.spring_jpa_query_handling.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Post", description = "APIs for managing posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/v1/posts")
    @Operation(summary = "Get all posts with their comments")
    public List<Post> getAllPosts() {
        log.info("GET /api/v1/posts - fetching all posts");
        return postService.findAll();
    }

    @GetMapping("/api/v1/posts/{id}")
    @Operation(summary = "Get a single post by ID with its comments")
    public Post getPostById(@PathVariable Long id) {
        log.info("GET /api/v1/posts/{} - fetching post", id);
        return postService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new post")
    public Post createPost(@Valid @RequestBody Post post) {
        log.info("POST /api/v1/posts - creating post: {}", post.getTitle());
        return postService.save(post);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a post and its comments by ID")
    public void deletePost(@PathVariable Long id) {
        log.info("DELETE /api/v1/posts/{} - deleting post", id);
        postService.deleteById(id);
    }
}