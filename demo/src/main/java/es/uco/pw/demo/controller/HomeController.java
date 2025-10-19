package es.uco.pw.demo.controller;

// --- AÑADIR ESTOS DOS IMPORTS ---
import es.uco.pw.demo.model.Boat;
import es.uco.pw.demo.model.Member;
// --- FIN DE LOS IMPORTS A AÑADIR ---

import es.uco.pw.demo.model.Registration;
import es.uco.pw.demo.model.Reservation;
import es.uco.pw.demo.repository.BoatRepository;
import es.uco.pw.demo.repository.MemberRepository;
import es.uco.pw.demo.repository.RegistrationRepository;
import es.uco.pw.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BoatRepository boatRepository;
    private final MemberRepository memberRepository;
    private final RegistrationRepository registrationRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public HomeController(BoatRepository boatRepository, 
                          MemberRepository memberRepository, 
                          RegistrationRepository registrationRepository,
                          ReservationRepository reservationRepository) {
        this.boatRepository = boatRepository;
        this.memberRepository = memberRepository;
        this.registrationRepository = registrationRepository;
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        
        List<Boat> boats = boatRepository.findAll();
        model.addAttribute("boats", boats);
        
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        
        List<Registration> registrations = registrationRepository.findAll();
        model.addAttribute("registrations", registrations);

        List<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        
        return "home";
    }
}