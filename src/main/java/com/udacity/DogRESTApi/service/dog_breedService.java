package com.udacity.DogRESTApi.service;

import com.udacity.DogRESTApi.web.Dog_breed;

import java.util.List;

public interface dog_breedService {
    List<Dog_breed> dog_breedservice();
    List<Dog_breed> dog_breedByID(Long id);
    Dog_breed dog_breedByName(String name);
    void createBreed(Dog_breed dogBreed);
    void deleteBreed(Long id);

}
