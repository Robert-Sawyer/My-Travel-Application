package com.github.robertsawyer.ItApp.domain.repositories;

import com.github.robertsawyer.ItApp.domain.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByCountry(String country);

    @Query(value = "SELECT name FROM countries WHERE name = ?",
    nativeQuery = true)
    String checkCountry(String country);                        //dostarczam nazwę kraju z formularza i szukam takiego w bazie
}
