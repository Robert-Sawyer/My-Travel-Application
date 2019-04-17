package com.github.robertsawyer.ItApp.dtos;

import com.github.robertsawyer.ItApp.domain.model.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTravelPlanDTO {


    @NotBlank
    private String name;
    private String description;


}
