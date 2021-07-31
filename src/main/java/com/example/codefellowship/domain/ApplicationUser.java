package com.example.codefellowship.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @Column(unique = true)
    private String username;
    private String password;


private String bio;
private String stName;
    private String lastName;
private String dob;


    @OneToMany( mappedBy = "applicationUser")
   private List<Post> posts;

    public ApplicationUser(Long id, String username, String password, String bio, String stName, String lastName, String dob, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.stName = stName;
        this.lastName = lastName;
        this.dob = dob;
        this.posts = posts;
    }

    public ApplicationUser(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public ApplicationUser(String bio, String stName, String lastName, String dob, String password, String username) {
        this.bio = bio;
        this.stName = stName;
        this.lastName = lastName;
        this.dob = dob;
        this.password = password;
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getBio() {
        return bio;
    }

    public String getStName() {
        return stName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ApplicationUser(Long id) {
        this.id = id;
    }

    public ApplicationUser() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
