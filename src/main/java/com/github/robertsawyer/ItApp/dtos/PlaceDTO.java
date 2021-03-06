package com.github.robertsawyer.ItApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {

    private String name;
    private String country;
    private String city;
    private String description;

}
