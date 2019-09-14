package com.github.robertsawyer.ItApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class AddPlaceDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String country;
    private String city;
    private String description;

    public AddPlaceDTO() {
    }

    public AddPlaceDTO(@NotBlank String name, @NotBlank String country, String city, String description) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
