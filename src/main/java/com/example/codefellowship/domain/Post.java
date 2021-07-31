package com.example.codefellowship.domain;

import javax.persistence.*;


@Entity(name = "Posts")
@Table(name = "post",
        uniqueConstraints = {
        @UniqueConstraint(name = "post_id_unique",columnNames = "id")
        }

)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String body;
    private String createdAt ;


    @ManyToOne
    private ApplicationUser applicationUser;

    public Post(Long id, String body, String createdAt, ApplicationUser applicationUser) {
        this.id = id;
        this.body = body;
        this.createdAt = createdAt;
        this.applicationUser = applicationUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }



    public Post() {
    }

    public Post(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }





    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Post(String body, String createdAt) {
        this.body = body;
        this.createdAt = createdAt;
    }
}
