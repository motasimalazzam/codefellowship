package com.example.demo.Infrastructure;

import com.example.demo.Model.AppUser;
import com.example.demo.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAppUserIn(Set<AppUser> appUserList);

}
