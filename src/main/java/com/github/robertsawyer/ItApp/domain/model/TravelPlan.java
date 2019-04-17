package com.github.robertsawyer.ItApp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "travel_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private List<Place> places;
    private String articles;


}
