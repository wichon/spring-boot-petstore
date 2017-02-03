package com.petstore.inventory.controllers;

import java.util.List;

import com.petstore.inventory.config.Info;
import com.petstore.inventory.models.Pet;
import com.petstore.inventory.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueryController {

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

    @RequestMapping(path = "/find/status/{status}", method = RequestMethod.GET)
    public List<Pet> findByStatus(@PathVariable("status") final String status) {
        return petRepository.findByStatus(status);
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public Info getInfo() {
        return info;
    }

    @RequestMapping(path = "/info/owner", method = RequestMethod.GET)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @RequestMapping(path = "/info/address", method = RequestMethod.GET)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @RequestMapping(path = "/info/phone", method = RequestMethod.GET)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
