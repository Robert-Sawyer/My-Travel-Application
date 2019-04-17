package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.AddPlaceDTO;
import com.github.robertsawyer.ItApp.services.PlaceService;
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

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public String prepareAddNewPlaceForm(Model model) {
        model.addAttribute("place", new AddPlaceDTO());
        return "places/AddPlaceForm";
    }

    @PostMapping
    public String addNewPlace(@Valid @ModelAttribute("place") AddPlaceDTO addPlaceDTO, BindingResult result, Principal principal){
        String name = principal.getName();
        if(!checkCountryExists(addPlaceDTO)) {                               //jeśli kraj nie istnieje to wywoła błąd i skieruje z powrotem do formularza
            result.rejectValue("country", null, "Taki kraj nie istnieje");
            return "places/AddPlaceForm";
        }
        placeService.createPlace(addPlaceDTO);
        return "redirect:/dashboard";                                         //jeśli kraj istnieje to zapisze miejsce i skieruje do kokpitu
    }

    private boolean checkCountryExists(AddPlaceDTO addPlaceDTO) {
        return placeService.checkCountry(addPlaceDTO.getCountry());         //jeśli kraj istnieje zwróci true, a jeśli nie to false

    }
}
