package es.uco.pw.demo.controller;

//IMPORTS NECESARIOS
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uco.pw.demo.model.Member;
import es.uco.pw.demo.repository.MemberRepository;

@Controller
@RequestMapping("/member") // URL base corregida
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Muestra el formulario para añadir un nuevo miembro.
     */
    @GetMapping("/add")
    public String showAddMemberForm(Model model) {
        model.addAttribute("newMember", new Member()); // Objeto corregido
        return "add-member"; // HTML corregido
    }

    /**
     * Guarda el nuevo miembro en la base de datos.
     */
    @PostMapping("/add")
    public String saveMember(@ModelAttribute("newMember") Member member) { // Objetos corregidos
        
        try {
            memberRepository.save(member);
            System.out.println("Miembro guardado con éxito: " + member.getFirstName());
        } catch (Exception e) {
            System.err.println("Error al guardar el miembro: " + e.getMessage());
            e.printStackTrace();
        }
        
        return "redirect:/";
    }
}