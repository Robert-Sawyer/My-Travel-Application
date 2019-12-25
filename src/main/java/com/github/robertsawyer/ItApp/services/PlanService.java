package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import com.github.robertsawyer.ItApp.domain.model.User;
import com.github.robertsawyer.ItApp.domain.repositories.PlaceRepository;
import com.github.robertsawyer.ItApp.domain.repositories.TravelPlanRepository;
import com.github.robertsawyer.ItApp.domain.repositories.UserRepository;
import com.github.robertsawyer.ItApp.dtos.AddExpenseDTO;
import com.github.robertsawyer.ItApp.dtos.AddPlaceToPlanDTO;
import com.github.robertsawyer.ItApp.dtos.AddTravelPlanDTO;
import com.github.robertsawyer.ItApp.dtos.EditTravelPlanDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanService {

    public static final Logger logger = LoggerFactory.getLogger(PlanService.class);

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravelPlanRepository travelPlanRepository;

    @Transactional
    public void createTravelPlan(AddTravelPlanDTO addTravelPlanDTO, String login) {
        TravelPlan travelPlan = Converters.convertToTravelPlan(addTravelPlanDTO);
        if (travelPlan == null) {
            throw new IllegalArgumentException("Nazwa musi być podana.");
        }
        User user = userRepository.findByLogin(login).get();
        travelPlan.setUser(user);
        travelPlanRepository.save(travelPlan);
    }

    public List<TravelPlan> getAllTravelPlans() {
        List<TravelPlan> plans = travelPlanRepository.findAll();
        return plans;
    }

    public TravelPlan getByName() {
        TravelPlan plan = travelPlanRepository.findByName();
        return plan;
    }

    @Transactional
    public void addPlaceToPlan(AddPlaceToPlanDTO placeToPlan) {
        logger.info(placeToPlan.toString());
        TravelPlan plan = travelPlanRepository.findById(placeToPlan.getPlanId()).get();
        Place place = placeRepository.findById(placeToPlan.getPlaceId()).get();
        List<Place> places = plan.getPlaces();
        places.add(place);
//        travelPlanRepository.save(plan);
    }

    public List<TravelPlan> getAllPublicTravelPlans() {
        List<TravelPlan> publicPlans = travelPlanRepository.findAllIfPublic();
        return publicPlans;
    }

    public void updateBudget(AddExpenseDTO addExpenseDTO) {

    }

    public void editPlan(EditTravelPlanDTO edit){
        TravelPlan plan = travelPlanRepository.findById(edit.getPlanId()).get();
        plan.setName(edit.getName());
        plan.setDescription(edit.getDescription());
        plan.setIsPublic(edit.getPublic());
        travelPlanRepository.save(plan);
    }
//    public EditTravelPlanDTO getDTOForEdit(Long id) {
//
//        return null;
//    }
}
