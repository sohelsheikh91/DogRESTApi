package com.udacity.DogRESTApi.repository;

import com.udacity.DogRESTApi.web.dog_breed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface dog_breedRepo extends CrudRepository <dog_breed,Long> {

    @Query("select d.id,d.breed from dog_breed d where d.id =:id")
    String findAllById(Long id);
    @Query("select d.id,d.breed from dog_breed d where d.name =:name")
    List<String> findAllBreed(String name);
}
