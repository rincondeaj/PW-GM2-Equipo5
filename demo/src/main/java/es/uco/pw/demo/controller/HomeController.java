package es.uco.pw.demo.controller;

import es.uco.pw.demo.model.Boat;
import es.uco.pw.demo.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BoatRepository boatRepository;

    @Autowired
    public HomeController(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        
        // 1. Obtenemos todos los barcos de la BBDD
        List<Boat> boats = boatRepository.findAll();
        
        // 2. Los añadimos al modelo para que la vista los pueda usar
        //    La vista accederá a esta lista llamándola "boats"
        model.addAttribute("boats", boats);
        
        // 3. Devolvemos el nombre de la plantilla (home.html)
        return "home";
    }
}