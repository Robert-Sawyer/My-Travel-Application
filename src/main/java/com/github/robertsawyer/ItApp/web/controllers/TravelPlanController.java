package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.AddTravelPlanDTO;
import com.github.robertsawyer.ItApp.dtos.FindPlaceDTO;
import com.github.robertsawyer.ItApp.services.PlaceService;
import com.github.robertsawyer.ItApp.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PlanService planService;

    public TravelPlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/add")
    public String prepareAddNewPlanForm(Model model){
        model.addAttribute("travelPlan", new AddTravelPlanDTO());
        return "/travels/AddPlanForm";
    }

    @PostMapping("/add")
    public String addNewPlan(@Valid @ModelAttribute("travelPlan") AddTravelPlanDTO addTravelPlanDTO, BindingResult result, Principal principal){
        String name = principal.getName();
        if (result.hasErrors()){
            return "travels/AddPlanForm";
        }
        planService.createTravelPlan(addTravelPlanDTO, name);
        return "redirect:/dashboard";
    }

    @GetMapping("/listAllPlans")
    public String showPlacesList(Model model){
        model.addAttribute("plans", planService.getAllTravelPlans());
//        model.addAttribute("place", planService.getPlacesList());
        return "travels/listAllPlans";
    }
}
