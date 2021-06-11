package es.portoman.web;

import es.portoman.domain.Persona;
import es.portoman.servicio.iPersonaService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller//Controlador MVC
@Slf4j
public class ControladorInicio {

    @Autowired
    private iPersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {

        var personas = personaService.listarPersonas();

        log.info("Ejecutando el controlador SpringMVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona=personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }
     @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona, Model model) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
