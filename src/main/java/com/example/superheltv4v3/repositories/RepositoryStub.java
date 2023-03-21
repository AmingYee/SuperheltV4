package com.example.superheltv4v3.repositories;


import com.example.superheltv4v3.dto.HeronameCityDTO;
import com.example.superheltv4v3.dto.HeronameCreationyearDTO;
import com.example.superheltv4v3.dto.HeronamePowerDTO;
import com.example.superheltv4v3.dto.HeronamePowernrDTO;
import com.example.superheltv4v3.model.Superhero;
import com.example.superheltv4v3.model.Superpower;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStub implements IRepository {
    private List<Superhero> superheroes = new ArrayList<>();

    public void RepositoryStub() {
        superheroes.add(new Superhero("Spiderman", "Peter Parker", 1994, true, 77));
        superheroes.add(new Superhero("Thor", "Thor", 881, false, 7777));
        superheroes.add(new Superhero("Iron Man", "Tony Stark", 1982, true, 88));
        superheroes.add(new Superhero("Batman", "Bruce Wayne", 1974, true, 2));
    }

    public List<HeronameCreationyearDTO> getAllSuperheroes() {
        List<HeronameCreationyearDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            returnlist.add(new HeronameCreationyearDTO(superhero.getId(), superhero.getRealName(), superhero.getCreationYear()));
        }
        return returnlist;
    }

    public List<HeronameCreationyearDTO> getHeroname(String heroName) {
        List<HeronameCreationyearDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                returnlist.add(new HeronameCreationyearDTO(superhero.getId(), superhero.getHeroName(), superhero.getCreationYear()));
            }
        }
        return returnlist;
    }

    public List<HeronamePowernrDTO> getPowernr() {
        List<HeronamePowernrDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            returnlist.add(new HeronamePowernrDTO(superhero.getHeroName(), superhero.getSuperpowers().size()));
        }
        return returnlist;
    }

    public List<HeronamePowernrDTO> getPowernrName(String heroName) {
        List<HeronamePowernrDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                returnlist.add(new HeronamePowernrDTO(superhero.getHeroName(), superhero.getSuperpowers().size()));
            }
        }
        return returnlist;
    }

    public List<HeronamePowerDTO> getSuperpower() {
        List<HeronamePowerDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            for (Superpower superpower : superhero.getSuperpowers()) {
                returnlist.add(new HeronamePowerDTO(superhero.getHeroName(), superpower.getName()));
            }
        }
        return returnlist;
    }

    public List<HeronamePowerDTO> getSuperpowerName(String heroName) {
        List<HeronamePowerDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                for (Superpower superpower : superhero.getSuperpowers()) {
                    returnlist.add(new HeronamePowerDTO(superhero.getHeroName(), superpower.getName()));
                }
            }
        }
        return returnlist;
    }

    public List<HeronameCityDTO> getHeroCity() {
        List<HeronameCityDTO> returnlist = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            returnlist.add(new HeronameCityDTO(superhero.getHeroName(), superhero.getCity().getCityName()));
        }
        return returnlist;
    }

    public List<HeronameCityDTO> getHeroCityName(String heroName) {
        List<HeronameCityDTO> returnlist = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equals(heroName)) {
                returnlist.add(new HeronameCityDTO(superhero.getHeroName(), superhero.getCity().getName()));;
            }
        }
        return returnlist;
    }
}