package com.example.demo.web;

import com.example.demo.Infrastructure.AppUserRepository;
import com.example.demo.Model.AppUser;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/usercreate")
    public RedirectView createUser(String username, String password, String dob, String firstname, String lastname, String bio) throws ParseException {
        String hashedpwd = bCryptPasswordEncoder.encode(password);
        Date DOB = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        AppUser newUser = new AppUser(username,hashedpwd, DOB, firstname, lastname, bio);
        appUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @GetMapping("/myprofile")
    public String getMyProfilePage(Principal p, Model m) {
        AppUser appUser = appUserRepository.findByUsername(p.getName());
        m.addAttribute("appUser",appUser);
        m.addAttribute("principal", p.getName());
        return "myprofile";
    }


    @GetMapping("/users/{id}")
    public String getSingleAppUserPage(Model m, Principal p, @PathVariable String id) {
        long ID = Long.parseLong(id);
        AppUser appUser = appUserRepository.findById(ID);
        m.addAttribute("appUser", appUser);
        m.addAttribute("principal", p.getName());

        return "singleappuser";
    }

    @GetMapping("/users")
    public String getUsersPage(Principal p, Model m) {
        AppUser appUser = appUserRepository.findByUsername(p.getName());
        Iterable<AppUser> users = appUserRepository.findAll();
        m.addAttribute("appUser",appUser);
        m.addAttribute("principal", p.getName());
        m.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/following")
    public String getFollowingPage(Principal p, Model m) {
        AppUser appUser = appUserRepository.findByUsername(p.getName());
        Iterable<AppUser> users = appUser.getFollowing();
        m.addAttribute("appUser",appUser);
        m.addAttribute("principal", p.getName());
        m.addAttribute("users", users);
        return "following";
    }

    @PostMapping("/follow/{id}")
    public RedirectView followUser(Principal p, @PathVariable long id) throws ParseException {

        AppUser loggedInUser = appUserRepository.findByUsername(p.getName());
        AppUser userToFollow = appUserRepository.findById(id);

        loggedInUser.getFollowing().add(userToFollow);
        userToFollow.getFollowers().add(loggedInUser);
        appUserRepository.save(loggedInUser);
        appUserRepository.save(userToFollow);

        return new RedirectView("/users");
    }




}
