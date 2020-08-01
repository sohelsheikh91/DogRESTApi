package com.udacity.DogRESTApi.controller;

import com.udacity.DogRESTApi.service.dog_breedServiceImpl;
import com.udacity.DogRESTApi.web.Dog_breed;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running."),
        @ApiResponse(code=404, message = "Data Not found for this ID")
})
public class DogBreedController {
    @Autowired
    dog_breedServiceImpl impl;

    @GetMapping(value="/dogBreed")
    public ResponseEntity<List<Dog_breed>> getAllBreeds(){
    List<Dog_breed> list = impl.dog_breedservice();
    return new ResponseEntity<List<Dog_breed>>(list, HttpStatus.OK);
    }
    @GetMapping("/dogBreed/{id}")
    public ResponseEntity<List<Dog_breed>> dogBreedByID(@PathVariable(value = "id") Long id){
        List<Dog_breed> list = impl.dog_breedByID(id);
        return new ResponseEntity<List<Dog_breed>>(list, HttpStatus.OK);
    }
//    @RequestMapping(method = RequestMethod.GET,value = "/dogBreed")
    @GetMapping(value ="/dogBreed",params = {"name"})
    public ResponseEntity<Dog_breed> dogBreedByName(@RequestParam(name = "name", required = true) String name){
        Dog_breed list = impl.dog_breedByName(name);
        return new ResponseEntity<Dog_breed>(list, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/dogBreed")
    @PostMapping("/dogBreed")
    public String setDogBreed(@RequestBody Dog_breed dogBreed){
        impl.createBreed(dogBreed);
        return "Dog Added";
    }

//    @RequestMapping(method = RequestMethod.PUT,value = "/dogBreed")
    @PutMapping("/dogBreed")
    public String updateDogBreed(@RequestBody Dog_breed dogBreed){
        impl.createBreed(dogBreed);
        return "Dog Updated";
    }

//    @RequestMapping(method = RequestMethod.DELETE,value = "/dogBreed/{id}")
    @DeleteMapping("/dogBreed/{id}")
    public String setDogBreed(@PathVariable Long id){
        impl.deleteBreed(id);
        return "Dog Deleted";
    }

}
