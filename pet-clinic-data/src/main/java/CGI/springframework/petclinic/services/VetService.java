package CGI.springframework.petclinic.services;

import CGI.springframework.petclinic.model.Owner;
import CGI.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);
    Vet findById (long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
