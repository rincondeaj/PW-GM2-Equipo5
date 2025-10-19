package es.uco.pw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uco.pw.demo.model.Boat;
import es.uco.pw.demo.repository.BoatRepository;

@Controller
@RequestMapping("/boat") // Todas las URLs de este controlador empezarán por /boat
public class BoatController {

    @Autowired
    private BoatRepository boatRepository;

    @GetMapping("/add")
    public String showAddBoatForm(Model model) {
        // Creamos un objeto Boat vacío para enlazarlo al formulario
        model.addAttribute("newBoat", new Boat());
        return "add-boat"; // Llama a add-boat.html
    }

    @PostMapping("/add")
    public String saveBoat(@ModelAttribute("newBoat") Boat boat) {
        
        // Usamos el repositorio que ya teníamos para guardar el barco
        try {
            boatRepository.save(boat);
            System.out.println("Barco guardado con éxito: " + boat.getName());
        } catch (Exception e) {
            System.err.println("Error al guardar el barco: " + e.getMessage());
            // Opcional: Redirigir a una página de error
        }
        
        // Después de guardar, redirigimos al usuario a la página principal
        return "redirect:/";
    }
}