package com.github.robertsawyer.ItApp.domain.repositories;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import com.github.robertsawyer.ItApp.dtos.AddPlaceToPlanDTO;
import com.github.robertsawyer.ItApp.dtos.TravelPlanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {

    @Query(value = "SELECT name FROM travels",
    nativeQuery = true)
    TravelPlan findByName();

    @Query(value = "SELECT place_id FROM travels_places WHERE travel_plan_id = ?",
    nativeQuery = true)
    List<Place> findAllPlaces(Long id);

    @Query(value = "SELECT * FROM places WHERE id NOT IN (select p.id from place p JOIN travels_places tp ON p.id = tp.places_id " +
            "JOIN travels t ON t.id = tp.travel_plan_id JOIN users u ON u.id = t.user_id WHERE u.login = ?)",
    nativeQuery = true)
    String getByUserLogin(String login);

    @Query(value = "SELECT * FROM travels WHERE is_public = 1",
    nativeQuery = true)
    List<TravelPlan> findAllIfPublic();
}

