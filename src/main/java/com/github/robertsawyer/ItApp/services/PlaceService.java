package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.repositories.PlaceRepository;
import com.github.robertsawyer.ItApp.dtos.AddPlaceDTO;
import com.github.robertsawyer.ItApp.dtos.FindPlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;


    public boolean checkCountry(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Kraj musi być podany.");        //jeśli pole kraj jest puste wyświetl błąd
        }
        try {
            String countryName = placeRepository.checkCountry(country);         //pobierz z bazy kraj o podanej nazwie
            if (countryName == null) {                                          //jeśli nie pobrało, znaczy, żę taki kraj nie istnieje
                return false;                                                   //wywoła false
            }
            else {
                return true;                                                    //jeśli taki kraj istnieje to zwróci true
            }
        } catch (RuntimeException re) {
            return false;
        }
    }

    @Transactional
    public void createPlace(AddPlaceDTO addPlaceDTO){                       //pobiera dane z formularza i wysyła do convertera, żeby przekształcił to na
        Place place = Converters.convertToPlace(addPlaceDTO);               //obiekt encji Place i otrzymane Place zapisujemy przy pomocy placeRepository
        placeRepository.save(place);                                        //do bazy danych
    }

    public List<Place> getAllPlaces(){
        List<Place> places = placeRepository.findAll();
        return places;
    }

    public Place findByName(FindPlaceDTO findPlaceDTO) {
        Place place = Converters.convertFindPlaceDTOToPlace(findPlaceDTO);
        return placeRepository.findByPlaceName(place);
    }

//    public List<Place> getNoAddedPlaces(){
//        List<Place> places = placeRepository.findNoAddedPlaces();
//        return places;
//    }
}
