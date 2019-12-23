package com.github.robertsawyer.ItApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homepage(){
        return "main/home";
    }
}
