package es.portoman.web;

import es.portoman.dao.iPersonaDao;
import es.portoman.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller//Controlador MVC
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private iPersonaDao personaDao;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var personas=personaDao.findAll();
        
        log.info("Ejecutando el controlador SpringMVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    
    
}
