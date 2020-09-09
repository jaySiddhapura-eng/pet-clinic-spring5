package CGI.springframework.petclinic.services.Map;

import CGI.springframework.petclinic.model.Owner;
import CGI.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    // this method is declared in CrudService
    @Override
    public Owner findByIdCrud(Long id) {
        return super.findByIdInMap(id);  // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public Owner saveCrud(Owner object) {
        return super.saveInMap(object.getId(),object);   // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public Set<Owner> findAllCrud() {
        return super.findAllInMap();     // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public void deleteByIdCrud(Long id) {
        super.deleteByIdInMap(id);       // this method is implemented in Abstract map service
    }

    // this method is declared in CrudService
    @Override
    public void deleteCrud(Owner object) {
        super.deleteInMap(object);       // this method is implemented in Abstract map service
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
