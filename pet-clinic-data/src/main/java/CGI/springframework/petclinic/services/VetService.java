package CGI.springframework.petclinic.services;

import CGI.springframework.petclinic.model.Owner;
import CGI.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}
