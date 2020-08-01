package com.udacity.DogRESTApi.web;

import javax.persistence.*;

@Entity
public class Dog_breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String breed;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog_breed(Long id, String breed, String name) {
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    public Dog_breed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
