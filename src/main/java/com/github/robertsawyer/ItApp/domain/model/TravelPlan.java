package com.github.robertsawyer.ItApp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "travels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = true)
    private String description;
    @ManyToMany
    private List<Place> places;

    @ManyToOne
    private User user;

    private String articles;
    private Boolean isPublic;


}
