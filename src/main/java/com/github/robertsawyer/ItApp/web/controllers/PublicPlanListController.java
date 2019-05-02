package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publicPlans")
public class PublicPlanListController {

    @Autowired
    private PlanService planService;

    public PublicPlanListController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public String showPlacesList(Model model){
        model.addAttribute("publicPlans", planService.getAllPublicTravelPlans());
        return "travels/listAllPublicPlans";
    }
}
