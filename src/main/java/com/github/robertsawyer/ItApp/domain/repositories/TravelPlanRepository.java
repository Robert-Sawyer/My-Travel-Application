package com.github.robertsawyer.ItApp.domain.repositories;

import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
}
