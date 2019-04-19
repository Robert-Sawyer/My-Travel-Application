package com.github.robertsawyer.ItApp.domain.repositories;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByCountry(String country);

    @Query(value = "SELECT name FROM countries WHERE name = ?",
    nativeQuery = true)
    String checkCountry(String country);                        //dostarczam nazwę kraju z formularza i szukam takiego w bazie

    @Query(value = "SELECT * FROM place WHERE id NOT IN (select p.id from place p JOIN trip_places tp ON p.id = tp.place_id JOIN trip t ON t.id = tp.trip_id JOIN users u ON u.id = t.user_id WHERE u.login = ?)",
    nativeQuery = true)
    String getByUserLogin(User login);


}
