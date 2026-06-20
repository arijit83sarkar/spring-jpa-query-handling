package com.raven.spring_jpa_query_handling.enitty;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() { return id; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }
}
