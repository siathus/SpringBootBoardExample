package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        httpSession.invalidate();
        return "index";
    }

    @GetMapping("/freeboardWritePage")
    public String freeboardWritePage() {
        return "freeboardWrite";
    }
}
