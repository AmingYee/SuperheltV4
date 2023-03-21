package com.example.superheltv4v3.controllers;

import com.example.superheltv4v3.dto.HeronameCityDTO;
import com.example.superheltv4v3.dto.HeronameCreationyearDTO;
import com.example.superheltv4v3.dto.HeronamePowerDTO;
import com.example.superheltv4v3.dto.HeronamePowernrDTO;
import com.example.superheltv4v3.repositories.IRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("superhelte")
public class SuperheroController {
    IRepository repository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        repository = (IRepository) context.getBean(impl);
    }
    @GetMapping("/test")
    public ResponseEntity<String> welcome(){
    return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<HeronameCreationyearDTO>> getHeroesByHeroName(@PathVariable String name) throws SQLException {
        List<HeronameCreationyearDTO> searchResults = repository.getHeroname(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/superpower/count/{name}")
    public ResponseEntity<List<HeronamePowernrDTO>> getSuperpowersCountByHeroName(@PathVariable String name) throws SQLException {
        List<HeronamePowernrDTO> superpowers = repository.getPowernrName(name);
        return new ResponseEntity<>(superpowers, HttpStatus.OK);
    }

    @GetMapping("/superpower/{name}")
    public ResponseEntity<List<HeronamePowerDTO>> getSuperpowersByHeroName(@PathVariable String name) {
        List<HeronamePowerDTO> superpowers = repository.getSuperpowerName(name);
        return new ResponseEntity<>(superpowers, HttpStatus.OK);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<List<HeronameCityDTO>> getCityByHeroName(@PathVariable String name) {
        List<HeronameCityDTO> heroesAndCities = repository.getHeroCityName(name);
        return new ResponseEntity<>(heroesAndCities, HttpStatus.OK);
    }
}