package com.github.robertsawyer.ItApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }
}
