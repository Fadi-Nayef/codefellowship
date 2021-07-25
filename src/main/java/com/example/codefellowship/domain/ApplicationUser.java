package com.example.codefellowship.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ApplicationUser implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Column(unique = true)
    private String password;

    private String username;

    public ApplicationUser(String username, String password) {
        this.password = password;
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
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
