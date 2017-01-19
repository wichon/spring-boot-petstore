package com.petstore.controller;

import java.util.List;

import com.petstore.config.Info;
import com.petstore.model.Pet;
import com.petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private Info info;

    @Value("${owner}")
    private String owner;

    @Value("${address}")
    private String address;

    @Value("${phone}")
    private String phone;

    @RequestMapping(path= "/", method = RequestMethod.GET)
    public List<Pet> index() {
        return petRepository.findAll();
    }

    @RequestMapping(path = "/find/{type}", method = RequestMethod.GET)
    public List<Pet> findByType(@PathVariable("type") final String type) {
        return petRepository.findByType(type);
    }

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

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public Info getInfo() {
        return info;
    }

    @RequestMapping(path = "/owner", method = RequestMethod.GET)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @RequestMapping(path = "/address", method = RequestMethod.GET)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @RequestMapping(path = "/phone", method = RequestMethod.GET)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
