package com.example.superheltv4v3.repositories;

import com.example.superheltv4v3.dto.HeronameCityDTO;
import com.example.superheltv4v3.dto.HeronameCreationyearDTO;
import com.example.superheltv4v3.dto.HeronamePowerDTO;
import com.example.superheltv4v3.dto.HeronamePowernrDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDB implements IRepository {
    String url = "jdbc:mysql://localhost:3306/superhero";
    String user = "root";
    String password = "3203327055";
    Connection connection = DriverManager.getConnection(url, user, password);
    String string;
    ResultSet eQ;
    Statement stmt;
    PreparedStatement ps;

    public RepositoryDB() throws SQLException {}

    @Override
    public List<HeronameCreationyearDTO> getAllSuperheroes() throws SQLException {
        ArrayList<HeronameCreationyearDTO> heroList = new ArrayList<>();
        try (Connection con = connection) {
            string = "SELECT * FROM superhero";
            stmt = con.createStatement();
            eQ = stmt.executeQuery(string);
            while (eQ.next()) {
                HeronameCreationyearDTO hero = new HeronameCreationyearDTO(
                        eQ.getInt("id"),
                        eQ.getString("name"),
                        eQ.getInt("creation_date")
                );
                heroList.add(hero);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    @Override
    public List<HeronameCreationyearDTO> getHeroname(String heroname) throws SQLException {
        ArrayList<HeronameCreationyearDTO> heroList = new ArrayList<>();
        try (Connection con = connection) {
            string = "SELECT * FROM superhero WHERE name = ?";
            ps = con.prepareStatement(string);
            ps.setString(1, heroname);
            eQ = ps.executeQuery();
            while (eQ.next()) {
                HeronameCreationyearDTO hero = new HeronameCreationyearDTO(
                        eQ.getInt("id"),
                        eQ.getString("name"),
                        eQ.getInt("creation_date")
                );
                heroList.add(hero);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    @Override
    public List<HeronamePowernrDTO> getPowernr() throws SQLException {
        ArrayList<HeronamePowernrDTO> heroList = new ArrayList<>();
        try (Connection con = connection) {
            string = "SELECT superhero_name, COUNT(*) as power_count FROM superhero_powers GROUP BY superhero_name";
            stmt = con.createStatement();
            eQ = stmt.executeQuery(string);
            while (eQ.next()) {
                String heroName = eQ.getString("superhero_name");
                int powerCount = eQ.getInt("power_count");
                HeronamePowernrDTO hero = new HeronamePowernrDTO(heroName, powerCount);
                heroList.add(hero);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    @Override
    public List<HeronamePowernrDTO> getPowernrName(String heroname) {
        ArrayList<HeronamePowernrDTO> heroList = new ArrayList<>();
        try (Connection con = connection) {
            string = "SELECT superhero_name, COUNT(*) as power_count FROM superhero_powers WHERE superhero_name = ?";
            ps = con.prepareStatement(string);
            ps.setString(1, heroname);
            eQ = ps.executeQuery();
            while (eQ.next()) {
                int powerCount = eQ.getInt("power_count");
                HeronamePowernrDTO hero = new HeronamePowernrDTO(heroname, powerCount);
                heroList.add(hero);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    @Override
    public List<HeronamePowerDTO> getSuperpower() {
        ArrayList<HeronamePowerDTO> heroList = new ArrayList<>();
        try (Connection con = connection) {
            string = "SELECT superhero.name, superpower.power FROM superhero JOIN hero_superpower ON superhero.id = hero_superpower.hero_id JOIN superpower ON hero_superpower.power_id = superpower.id";
            ps = con.prepareStatement(string);
            eQ = ps.executeQuery();
            while (eQ.next()) {
                String name = eQ.getString("name");
                String power = eQ.getString("power");
                HeronamePowerDTO hero = new HeronamePowerDTO(name, power);
                heroList.add(hero);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return heroList;
    }

    @Override
    public List<HeronamePowerDTO> getSuperpowerName(String heroname) {
        return null;
    }

    @Override
    public List<HeronameCityDTO> getHeroCity() {
        return null;
    }

    @Override
    public List<HeronameCityDTO> getHeroCityName(String heroname) {
        return null;
    }
}
