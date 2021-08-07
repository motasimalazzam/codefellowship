package com.example.demo.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    String username;

    String password;
    Date dob;
    String firstname;
    String lastname;
    String bio;

    @OneToMany(mappedBy = "appUser")
    List<Post> posts;

    @ManyToMany
    private Set<AppUser> followers;

    @ManyToMany
   private Set<AppUser> following;

    public AppUser() {
    }

    public AppUser(String username, String password, Date dob, String firstname, String lastname, String bio) {
        this.password = password;
        this.username = username;
        this.dob = dob;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
    }

    public AppUser(String username, String password) {
        this.password = password;
        this.username = username;
    }


    public String getUsername() {
        return this.username;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getDob() {
        return dob;
    }

    public String getBio() {
        return bio;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<AppUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<AppUser> followers) {
        this.followers = followers;
    }

    public Set<AppUser> getFollowing() {
        return following;
    }

    public void setFollowing(Set<AppUser> following) {
        this.following = following;
    }
}