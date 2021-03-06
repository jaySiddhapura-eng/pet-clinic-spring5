package CGI.springframework.petclinic.services.Map;

import CGI.springframework.petclinic.model.Vet;
import CGI.springframework.petclinic.services.CrudService;
import CGI.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    // this method is declared in CrudService
    @Override
    public Vet findByIdCrud(Long id) {
        return super.findByIdInMap(id);      // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public Vet saveCrud(Vet object) {
        return super.saveInMap(object); // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public Set<Vet> findAllCrud() {
        return super.findAllInMap(); // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public void deleteByIdCrud(Long id) {
        super.deleteByIdInMap(id); // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public void deleteCrud(Vet object) {
        super.deleteInMap(object); // this method is implemented in Abstract map service
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
