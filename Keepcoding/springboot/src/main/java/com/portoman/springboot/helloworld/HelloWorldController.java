package com.portoman.springboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portoman.springboot.helloworld.BeanResponse;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

//1. Anotar la clase como un controlador
//2. Crear métodos que respondan a los endpoints
//3. Configurar esos métodos

@RestController
public class HelloWorldController {
    
    
     @Autowired
    private MessageSource messageSource;
     
     
    //GET
    //@RequestMapping(value="/hello-world", method= RequestMethod.GET)
    @GetMapping(value="/hello-world")
    public String helloWorld(@RequestHeader(name="Accept-Language", required=false)Locale locale){
        return messageSource.getMessage("hello.world.message", null ,locale);
    }
    
    @GetMapping(value="/hello-world-bean")
    public @ResponseBody BeanResponse helloWorldBean(){
        return new BeanResponse ("Hello World Bean!");
    }
    
    @GetMapping(value="/hello-world/path-variable/{name}")
    public String helloWorldVariable(@PathVariable String name){
        return "Hello " + name +" !";
    }
    
   
}
