package com.github.robertsawyer.ItApp.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "places")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column
    private String city;
    @Column
    private String description;
}
