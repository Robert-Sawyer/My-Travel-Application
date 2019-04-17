package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.AddTravelPlanDTO;
import com.github.robertsawyer.ItApp.services.PlaceService;
import com.github.robertsawyer.ItApp.services.PlanService;
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

    private PlaceService placeService;

    private PlanService planService;

    public TravelPlanController(PlaceService placeService, PlanService planService) {
        this.placeService = placeService;
        this.planService = planService;
    }

    @GetMapping
    public String prepareAddNewPlanForm(Model model){
        model.addAttribute("travelPlan", new AddTravelPlanDTO());
        return "/travels/AddPlanForm";
    }

    @PostMapping
    public String addNewPlan(@Valid @ModelAttribute("travelPlan") AddTravelPlanDTO addTravelPlanDTO, BindingResult result, Principal principal){
        String name = principal.getName();
        if (result.hasErrors()){
            return "travels/AddPlanForm";
        }
        planService.createTravelPlan(addTravelPlanDTO);
        return "redirect:dashboard";
    }

}
