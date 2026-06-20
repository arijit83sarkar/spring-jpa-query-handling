package com.raven.spring_jpa_query_handling.controller;

import com.raven.spring_jpa_query_handling.enitty.Post;
import com.raven.spring_jpa_query_handling.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Tag(name = "Post", description = "APIs for managing posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @Operation(summary = "Get all posts with their comments")
    public List<Post> getAllPosts() {
        log.info("GET /posts - fetching all posts");
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a single post by ID with its comments")
    public Post getPostById(@PathVariable Long id) {
        log.info("GET /posts/{} - fetching post", id);
        return postService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new post")
    public Post createPost(@Valid @RequestBody Post post) {
        log.info("POST /posts - creating post: {}", post.getTitle());
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a post and its comments by ID")
    public void deletePost(@PathVariable Long id) {
        log.info("DELETE /posts/{} - deleting post", id);
        postService.deleteById(id);
    }
}