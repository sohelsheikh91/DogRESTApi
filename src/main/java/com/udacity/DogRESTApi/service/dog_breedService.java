package com.udacity.DogRESTApi.service;

import com.udacity.DogRESTApi.web.dog_breed;

import java.util.List;

public interface dog_breedService {
    List<dog_breed> dog_breedservice();
    String dog_breedByID(Long id);
    List<String> dog_breedByName(String name);

}
