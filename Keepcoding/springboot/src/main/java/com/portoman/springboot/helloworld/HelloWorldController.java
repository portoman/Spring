package com.portoman.springboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portoman.springboot.helloworld.BeanResponse;
import org.springframework.web.bind.annotation.PathVariable;

//1. Anotar la clase como un controlador
//2. Crear métodos que respondan a los endpoints
//3. Configurar esos métodos

@RestController
public class HelloWorldController {
    
    // /hello-world
    //GET
    //@RequestMapping(value="/hello-world", method= RequestMethod.GET)
    @GetMapping(value="/hello-world")
    public @ResponseBody String helloWorld(){
        return "Hello World!";
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
