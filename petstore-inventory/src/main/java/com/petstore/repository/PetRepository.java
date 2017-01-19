package com.petstore.repository;

import java.util.List;
import com.petstore.model.Pet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wichon on 1/15/17.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
    @Cacheable("pets-by-type")
    List<Pet> findByType(String type);

    @Cacheable("pets-all")
    List<Pet> findAll();
}
