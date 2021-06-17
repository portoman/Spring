package es.portoman;

import es.portoman.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller//Controlador MVC
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje="Mensaje con Thymeleaf";
        
        var persona1=new Persona();
        persona1.setNombre("Alfonso");
        persona1.setApellido("Porto");
        persona1.setEmail("portbuj@yahoo.es");
        persona1.setTelefono("620771628");
        
        var persona2=new Persona();
        persona2.setNombre("Lurdes");
        persona2.setApellido("Martinez");
        persona2.setEmail("lmartinez@gmail.com");
        persona2.setTelefono("685646889");
        
        var persona3=new Persona();
        persona3.setNombre("Paco");
        persona3.setApellido("Fernandez");
        persona3.setEmail("pfernandez@gmail.com");
        persona3.setTelefono("685646889");
        
//        List<Persona> personas=new ArrayList();
//        personas.add(persona1);
//        personas.add(persona2);
//        personas.add(persona3);
              
        var personas=Arrays.asList(persona1, persona2, persona3);

//        List<Persona> personas=new ArrayList();

        
        log.info("Ejecutando el controlador SpringMVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
       // model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
    
    
}
