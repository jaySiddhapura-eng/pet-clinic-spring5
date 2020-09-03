package CGI.springframework.petclinic.services.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID>{
    protected Map<ID, T> map = new HashMap<ID,T>();

    Set<T> findAllInMap(){
        return new HashSet<>(map.values());
    }

    T findByIdInMap(ID id){
        return map.get(id);
    }

    T saveInMap(ID id, T object){
        map.put(id, object);
        return object;
    }

    void deleteByIdInMap(ID id){
        map.remove(id);
    }

    void deleteInMap(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
        //map.remove(object);
    }
}
