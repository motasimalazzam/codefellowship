package com.example.demo.Model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String body;
    Timestamp createdAt;

    @ManyToOne
    AppUser appUser;

    public Post(){}

    public Post(String body, Timestamp createdAt, AppUser appUser) {
        this.body = body;
        this.createdAt = createdAt;
        this.appUser = appUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}