package CGI.springframework.petclinic.Controllers;

import CGI.springframework.petclinic.model.Vet;
import CGI.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "vets/index.html"})
    public String vetList(Model model){
        model.addAttribute("vets",vetService.findAllCrud());
        return "vets/index";
    }
}
