package es.uco.pw.demo.controller;

import es.uco.pw.demo.model.Registration;
import es.uco.pw.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("newRegistration", new Registration());
        return "add-registration"; // Llama a add-registration.html
    }

    @PostMapping("/add")
    public String saveRegistration(@ModelAttribute("newRegistration") Registration registration) {
        try {
            registrationRepository.save(registration);
        } catch (Exception e) {
            e.printStackTrace();
            // redirigir a una página de error
        }
        return "redirect:/"; // Vuelve a la página principal
    }
}