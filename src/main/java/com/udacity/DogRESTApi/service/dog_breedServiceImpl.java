package com.udacity.DogRESTApi.service;

import com.udacity.DogRESTApi.repository.dog_breedRepo;
import com.udacity.DogRESTApi.web.Dog_breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class dog_breedServiceImpl implements dog_breedService{

    @Autowired
    dog_breedRepo dog_breedRepo;

    @Override
    public List<Dog_breed> dog_breedservice() {
        return (List<Dog_breed>) dog_breedRepo.findAll();
    }

    @Override
    public List<Dog_breed> dog_breedByID(Long id) {
        Optional<Iterable<Dog_breed>> optionalBreed = Optional.ofNullable(dog_breedRepo.findAllById(Collections.singleton(id)));
        Iterable<Dog_breed> breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        List<Dog_breed> list = new ArrayList<Dog_breed>();
        breed.forEach(list::add);
        return list;

    }
    @Override
    public Dog_breed dog_breedByName(String str) {
        Optional<Dog_breed> optionalBreed = Optional.ofNullable(dog_breedRepo.findByName(str));
        Dog_breed breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
     //   return (List<String>) dog_breedRepo.findAllBreed(str);
    }

    public void createBreed(Dog_breed dogBreed) {
        dog_breedRepo.save(dogBreed);
    }

    public void deleteBreed(Long id) {
        dog_breedRepo.deleteById(id);
    }
}
