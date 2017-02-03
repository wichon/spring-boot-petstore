package com.petstore.inventory.repositories;

import java.util.List;
import com.petstore.inventory.models.Pet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wichon on 1/15/17.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
    @Cacheable("pets-by-type")
    List<Pet> findByType(String type);

    List<Pet> findByStatus(String status);

    @Cacheable("pets-all")
    List<Pet> findAll();
}
