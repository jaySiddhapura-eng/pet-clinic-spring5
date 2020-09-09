package CGI.springframework.petclinic.services.Map;

import CGI.springframework.petclinic.model.Pet;
import CGI.springframework.petclinic.services.CrudService;
import CGI.springframework.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    // this method is declared in CrudService
    @Override
    public Pet findByIdCrud(Long id) {
        return super.findByIdInMap(id);  // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public Pet saveCrud(Pet object) {
        return super.saveInMap(object); // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public Set<Pet> findAllCrud() {
        return super.findAllInMap(); // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public void deleteByIdCrud(Long id) {
        super.deleteByIdInMap(id); // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public void deleteCrud(Pet object) {
        super.deleteInMap(object); // this method is implemented in Abstract map service
    }
}
