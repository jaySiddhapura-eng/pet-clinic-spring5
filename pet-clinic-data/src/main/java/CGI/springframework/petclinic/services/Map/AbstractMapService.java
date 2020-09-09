package CGI.springframework.petclinic.services.Map;

import CGI.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>{
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAllInMap(){
        return new HashSet<>(map.values());
    }

    T findByIdInMap(ID id){
        return map.get(id);
    }

    T saveInMap(T object){
        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    private Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

    void deleteByIdInMap(ID id){
        map.remove(id);
    }

    void deleteInMap(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
        //map.remove(object);
    }
}
