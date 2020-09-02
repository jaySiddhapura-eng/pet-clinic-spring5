package CGI.springframework.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    // non primitive id variable suggested by hybernet
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
