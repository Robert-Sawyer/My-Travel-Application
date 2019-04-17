package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import com.github.robertsawyer.ItApp.domain.repositories.TravelPlanRepository;
import com.github.robertsawyer.ItApp.dtos.AddTravelPlanDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanService {

    private TravelPlanRepository travelPlanRepository;

    @Transactional
    public void createTravelPlan(AddTravelPlanDTO addTravelPlanDTO) {
        TravelPlan travelPlan = Converters.convertToTravelPlan(addTravelPlanDTO);
        travelPlanRepository.save(travelPlan);
    }
    
}
