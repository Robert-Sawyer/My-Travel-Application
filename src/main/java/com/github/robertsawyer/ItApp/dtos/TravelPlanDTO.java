package com.github.robertsawyer.ItApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPlanDTO {


    @NotBlank
    private String name;
    private String description;
    private PlaceDTO placeDTO;

}
