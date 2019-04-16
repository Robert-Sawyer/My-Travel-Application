package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.TravelPlanDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("travel-plan")
public class TravelPlanController {

    @GetMapping
    public String prepareAddNewPlanForm(Model model){
        model.addAttribute("travelPlan", new TravelPlanDTO());
        return "/travels/AddPlanForm";
    }

    @PostMapping
    public String addNewPlan(@Valid @ModelAttribute("travelPlan") TravelPlanDTO travel, BindingResult result, Principal principal){
        String name = principal.getName();
        return "redirect:dashboard";
    }
}
