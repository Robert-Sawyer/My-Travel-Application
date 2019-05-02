package com.github.robertsawyer.ItApp.dtos;

import com.github.robertsawyer.ItApp.domain.model.Place;
import com.github.robertsawyer.ItApp.domain.model.TravelPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPlaceToPlanDTO {

    private Long planId;
    private Long placeId;

}
