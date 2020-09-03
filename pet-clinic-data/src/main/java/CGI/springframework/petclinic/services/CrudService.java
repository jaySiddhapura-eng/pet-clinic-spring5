package CGI.springframework.petclinic.services;

import java.util.Set;

public interface CrudService <T, ID> {
    T findByIdCrud(ID id);
    T saveCrud(T object);
    Set<T> findAllCrud();
    void deleteCrud(T object);
    void deleteByIdCrud(ID id);
}
