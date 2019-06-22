package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import com.github.robertsawyer.ItApp.dtos.AddPlaceDTO;
import com.github.robertsawyer.ItApp.dtos.AddPlaceToPlanDTO;
import com.github.robertsawyer.ItApp.dtos.FindPlaceDTO;
import com.github.robertsawyer.ItApp.dtos.TravelPlanDTO;
import com.github.robertsawyer.ItApp.services.PlaceService;
import com.github.robertsawyer.ItApp.services.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/places")
public class PlaceController {

    public static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlanService planService;

    public PlaceController(PlaceService placeService, PlanService planService) {
        this.placeService = placeService;
        this.planService = planService;
    }

    @GetMapping("/add")
    public String prepareAddNewPlaceForm(Model model) {
        model.addAttribute("place", new AddPlaceDTO());
        return "places/AddPlaceForm";
    }

    @PostMapping("/add")
    public String addNewPlace(@Valid @ModelAttribute("place") AddPlaceDTO addPlaceDTO, BindingResult result, Principal principal){
        String name = principal.getName();
        if (result.hasErrors()) {
            return "places/AddPlaceForm";
        }
        if(!checkCountryExists(addPlaceDTO)) {                               //jeśli kraj nie istnieje to wywoła błąd i skieruje z powrotem do formularza
            result.rejectValue("country", null, "Taki kraj nie istnieje");
            return "places/AddPlaceForm";
        }
        logger.info("Zapisuję miejsce: " + addPlaceDTO);
        placeService.createPlace(addPlaceDTO);
        return "redirect:/dashboard";                                         //jeśli kraj istnieje to zapisze miejsce i skieruje do kokpitu
    }

    @GetMapping("/listAllPlaces")
    public String showPlacesList(Model model){
        model.addAttribute("placeName", new FindPlaceDTO());
        model.addAttribute("places", placeService.getAllPlaces());
        model.addAttribute("plans", planService.getAllTravelPlans());
        model.addAttribute("addPlaceToPlan", new AddPlaceToPlanDTO());
        //dodać logikę wyświetlającą listę miejsc nie związanych z żadnym z planów zalogowanego użytjownika
        return "places/listAllPlaces";
    }

    @PostMapping(value = "/listAllPlaces", params = "search")
    public Place findPlace(@ModelAttribute("placeName") FindPlaceDTO placeName){
        return placeService.findByName(placeName);
    }

    @PostMapping(value = "/listAllPlaces", params = "addToPlan")
    public String addPlaceToPlan(@ModelAttribute("addPlaceToPlan") AddPlaceToPlanDTO placeToPlan){
        logger.info(placeToPlan.toString());
        planService.addPlaceToPlan(placeToPlan);
        return "redirect:/places/listAllPlaces";
    }



//    @PostMapping("/listAllPlaces")
//    public TravelPlanDTO showPlanName(@ModelAttribute("plans") TravelPlanDTO planName){
//        return planService.findByName(planName);
//    }


    private boolean checkCountryExists(AddPlaceDTO addPlaceDTO) {
        return placeService.checkCountry(addPlaceDTO.getCountry());         //jeśli kraj istnieje zwróci true, a jeśli nie to false
    }
}
