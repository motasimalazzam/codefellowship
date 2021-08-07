package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getCodefellowship(Principal p, Model m) {
        if(p != null){
            m.addAttribute("principal", p.getName());
        }else{
            m.addAttribute("principal", null);
        }

        return "codefellowship";
    }
}
