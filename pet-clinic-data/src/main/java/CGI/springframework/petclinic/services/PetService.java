package CGI.springframework.petclinic.services;

import CGI.springframework.petclinic.model.Owner;
import CGI.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById (long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
