package com.github.robertsawyer.ItApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPlaceDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String country;
    private String city;
    private String description;
}
