package com.portoman.springboot.controler;

import org.springframework.web.bind.annotation.RestController;
import com.portoman.springboot.helloworld.dao.HeroDaoService;
import com.portoman.springboot.helloworld.model.Hero;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.portoman.springboot.exceptions.HeroNotFoundException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class HeroController {

    @Autowired
    private HeroDaoService heroDaoService;

    //Encontrar todos los héroes
    @GetMapping("/hero")
    public List<Hero> findAllHeroes() {
        return heroDaoService.findAll();
    }

    //Buscar un héroe
    @GetMapping("/hero/{id}")
    public Hero findHeroById(@PathVariable int id) {
        Hero result = heroDaoService.findHeroById(id);
        if (result == null) {
            throw new HeroNotFoundException("El héroe con id " + id + " no existe.");
        }
        return result;
    }

    @DeleteMapping("/hero/{id}")
    public void deleteHeroById(@PathVariable int id) {
        boolean result = heroDaoService.deleteHero(id);
        if (result==false) {
            throw new HeroNotFoundException("El héroe con id " + id + " no existe.");
        }
    }

    //POST
    //Devolver estado 201: Created
    //Devolver uri del nuevo recurso creado
    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody @Valid Hero hero) {
        Hero addedHero = heroDaoService.addHero(hero);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedHero.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
