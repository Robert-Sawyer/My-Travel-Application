package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import com.github.robertsawyer.ItApp.domain.model.User;
import com.github.robertsawyer.ItApp.dtos.*;

public class Converters {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
//        userDTO.setFirstName(user.getFirstName());
//        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

    public static User convertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
//        user.setFirstName(form.getFirstName());
//        user.setLastName(form.getLastName());
        return user;
    }

    public static Place convertToPlace(AddPlaceDTO addPlaceDTO) {       //przyjmuje dane z formularza w formie obiektu addPlaceDTO i konwertuje to na
        Place place = new Place();                                      //obiekt encji Place
        place.setName(addPlaceDTO.getName());
        place.setCountry(addPlaceDTO.getCountry());
        place.setCity(addPlaceDTO.getCity());
        place.setDescription(addPlaceDTO.getDescription());
        return place;
    }


    public static TravelPlan convertToTravelPlan(AddTravelPlanDTO addTravelPlanDTO) {
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setName(addTravelPlanDTO.getName());
        travelPlan.setDescription(addTravelPlanDTO.getDescription());
        travelPlan.setIsPublic(addTravelPlanDTO.getIsPublic());
        return travelPlan;
    }

    public static Place convertFindPlaceDTOToPlace(FindPlaceDTO findPlaceDTO) {
        Place place = new Place();
        place.setName(findPlaceDTO.getName());
        return place;
    }
}
