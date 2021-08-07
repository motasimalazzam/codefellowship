package com.example.demo.Infrastructure;


import com.example.demo.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
     AppUser findByUsername(String username);
     AppUser findById(long id);
}
