package com.example.superheltv4v3.repositories;

import com.example.superheltv4v3.dto.HeronameCityDTO;
import com.example.superheltv4v3.dto.HeronameCreationyearDTO;
import com.example.superheltv4v3.dto.HeronamePowerDTO;
import com.example.superheltv4v3.dto.HeronamePowernrDTO;

import java.sql.SQLException;
import java.util.List;

public interface IRepository {
    List<HeronameCreationyearDTO> getAllSuperheroes() throws SQLException;
    List<HeronameCreationyearDTO> getHeroname(String heroname) throws SQLException;

    List <HeronamePowernrDTO> getPowernr() throws SQLException;
    List <HeronamePowernrDTO> getPowernrName(String heroname);

    List<HeronamePowerDTO> getSuperpower();
    List<HeronamePowerDTO> getSuperpowerName(String heroname);

    List<HeronameCityDTO> getHeroCity();
    List<HeronameCityDTO> getHeroCityName(String heroname);
}
