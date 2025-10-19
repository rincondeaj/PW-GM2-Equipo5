package es.uco.pw.demo.controller;

//IMPORTS NECESARIOS
import es.uco.pw.demo.model.Member;
import es.uco.pw.demo.model.Registration;
import es.uco.pw.demo.model.Reservation;
import es.uco.pw.demo.repository.MemberRepository;
import es.uco.pw.demo.repository.RegistrationRepository;
import es.uco.pw.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private MemberRepository memberRepository; // Dependencia de Member
    @Autowired
    private RegistrationRepository registrationRepository; // Dependencia de Registration

    /**
     * Muestra el formulario para añadir una nueva reserva
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        //Cargar members para el despliegue
        List<Member> allMembers = memberRepository.findAll();
        
        //Carga las matriculas para el desplegable
        List<Registration> allRegistrations = registrationRepository.findAll();

        //Añade vistas o modelo vacio para el formulario
        model.addAttribute("allMembers", allMembers);
        model.addAttribute("allRegistrations", allRegistrations);
        model.addAttribute("newReservation", new Reservation());
        
        return "add-reservation"; // Llama a add-reservation.html
    }

    /**
     * Guarda la nueva reserva
     */
    @PostMapping("/add")
    public String saveReservation(@ModelAttribute("newReservation") Reservation reservation) {
        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            e.printStackTrace();
            // redirigir a página de error
        }
        return "redirect:/"; // Vuelve a la página principal
    }
}