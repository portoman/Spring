package es.portoman.dao;

import es.portoman.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface iPersonaDao extends CrudRepository<Persona, Long>{
    
}
