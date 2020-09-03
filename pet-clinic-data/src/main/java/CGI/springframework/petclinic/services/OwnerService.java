package CGI.springframework.petclinic.services;

import CGI.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService <Owner, Long>{
    Owner findByLastName(String lastName);
}
