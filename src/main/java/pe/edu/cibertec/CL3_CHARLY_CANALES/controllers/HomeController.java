package pe.edu.cibertec.CL3_CHARLY_CANALES.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/nosotros")
    public String about() {
        return "about";
    }
    
    
}