package com.petstore.inventory.controllers;

import com.petstore.inventory.models.Pet;
import com.petstore.inventory.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wichon on 2/3/17.
 */
@RestController
public class CrudController {

    @Autowired
    private PetRepository petRepository;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @CacheEvict(cacheNames= {"pets-all", "pets-by-type"}, allEntries=true)
    public long add(@RequestBody Pet pet) {
        petRepository.save(pet);
        return petRepository.count();
    }

    @RequestMapping(path = "/add-bulk", method = RequestMethod.POST)
    @CacheEvict(cacheNames= {"pets-all", "pets-by-type"}, allEntries=true)
    public long add(@RequestBody List<Pet> pets) {
        petRepository.save(pets);
        return petRepository.count();
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @CacheEvict(cacheNames= {"pets-all", "pets-by-type"}, allEntries=true)
    public Pet update(@RequestBody Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    @CacheEvict(cacheNames= {"pets-all", "pets-by-type"}, allEntries=true)
    public long deleteById(@PathVariable("id") final Long id) {
        petRepository.delete(id);
        return petRepository.count();
    }
}