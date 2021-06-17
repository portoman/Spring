package com.portoman.springboot.helloworld.model;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Hero {

    private int id;
    @Size(min=3)//Validaciones
    private String name;
    private String heroName;
    @Past
    private Date birthDate;

    public Hero() {
    }

    public Hero(int id, String name, String heroName, Date birthDate) {
        this.id = id;
        this.name = name;
        this.heroName = heroName;
        this.birthDate = birthDate;
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

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
