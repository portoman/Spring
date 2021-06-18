package com.portoman.springboot.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value={"password"})//También para no mostrar el atributo(Filtrado estático)
@JsonFilter("UserFilter")
public class UserFilteredDto {
    
    private int id;
    private String name;
    
    //@JsonIgnore//Para no mostrar el atributo (Filtrado estático)
    private String password;

    public UserFilteredDto(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserFilteredDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
