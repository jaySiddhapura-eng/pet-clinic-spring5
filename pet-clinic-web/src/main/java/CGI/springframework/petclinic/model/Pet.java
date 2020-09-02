package CGI.springframework.petclinic.model;

import java.time.LocalDate;

public class Pet {
    private petType petType;
    private Owner owner;
    private LocalDate birthDate;

    public CGI.springframework.petclinic.model.petType getPetType() {
        return petType;
    }

    public void setPetType(CGI.springframework.petclinic.model.petType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
