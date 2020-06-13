package com.udacity.DogRESTApi.controller;

import com.udacity.DogRESTApi.service.dog_breedServiceImpl;
import com.udacity.DogRESTApi.web.dog_breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogBreedController {
    @Autowired
    dog_breedServiceImpl Impl;

    @GetMapping("/dogBreed")
    public ResponseEntity<List<dog_breed>> getAllLocations(){
    List<dog_breed> list = Impl.dog_breedservice();
    return new ResponseEntity<List<dog_breed>>(list, HttpStatus.OK);
    }
    @GetMapping("/dogBreedById/{id}")
    public ResponseEntity<String> dog_breedByID(@PathVariable(value = "id") Long id){
        String list = Impl.dog_breedByID(id);
        return new ResponseEntity<String>(list, HttpStatus.OK);
    }
    @GetMapping("/dogBreedByName/{name}")
    public ResponseEntity<List<String>> dog_breedByID(@PathVariable(value = "name") String str){
        List<String> list = Impl.dog_breedByName(str);
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }



}
