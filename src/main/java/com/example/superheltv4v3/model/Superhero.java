package com.example.superheltv4v3.model;

import java.util.List;

public class Superhero {
    private int id;
    private String heroName;
    private String realName;
    private int creationYear;
    private boolean isHuman;
    private City city;
    private List<Superpower> superpowers;
    private double power;


    public Superhero(String heroName, String realName, int creationYear, boolean isHuman, double power) {
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.isHuman = isHuman;
        this.power = power;
    }


    public int getId() {
        return id;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public boolean isHuman() {
        return isHuman;
    }


    public City getCity() {
        return city;
    }

    public List<Superpower> getSuperpowers() {
        return superpowers;
    }

    public double getPower() {
        return power;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setSuperpowers(List<Superpower> superpowers) {
        this.superpowers = superpowers;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
