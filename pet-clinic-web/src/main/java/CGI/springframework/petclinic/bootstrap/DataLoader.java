package CGI.springframework.petclinic.bootstrap;

import CGI.springframework.petclinic.model.Owner;
import CGI.springframework.petclinic.model.Vet;
import CGI.springframework.petclinic.services.Map.OwnerServiceMap;
import CGI.springframework.petclinic.services.Map.VetServiceMap;
import CGI.springframework.petclinic.services.OwnerService;
import CGI.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("abc");
        owner1.setLastName("def");
        ownerService.saveCrud(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("pqr");
        owner2.setLastName("stu");
        ownerService.saveCrud(owner2);

        System.out.println("Owners loaded..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("jkl");
        vet1.setLastName("mno");
        vetService.saveCrud(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("efg");
        vet2.setLastName("hij");
        vetService.saveCrud(vet2);

        System.out.println("Vets loaded..");

    }
}
