package CGI.springframework.petclinic.Controllers;

import CGI.springframework.petclinic.model.Owner;
import CGI.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"owners", "owners/index", "owners/index.html"})
    public String OwnerList(Model model){
        model.addAttribute("owners", ownerService.findAllCrud());
        return "owners/index";
    }
}
