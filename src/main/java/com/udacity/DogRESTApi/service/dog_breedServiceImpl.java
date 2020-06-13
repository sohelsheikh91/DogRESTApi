package com.udacity.DogRESTApi.service;

import com.udacity.DogRESTApi.repository.dog_breedRepo;
import com.udacity.DogRESTApi.web.dog_breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class dog_breedServiceImpl implements dog_breedService{

    @Autowired
    dog_breedRepo dog_breedRepo;

    @Override
    public List<dog_breed> dog_breedservice() {
        return (List<dog_breed>) dog_breedRepo.findAll();
    }

    @Override
    public String dog_breedByID(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dog_breedRepo.findAllById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;

    }
    @Override
    public List<String> dog_breedByName(String str) {
        Optional<List<String>> optionalBreed = Optional.ofNullable(dog_breedRepo.findAllBreed(str));
        List<String> breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
     //   return (List<String>) dog_breedRepo.findAllBreed(str);
    }
}
