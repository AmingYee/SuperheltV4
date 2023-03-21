package com.example.superheltv4v3.dto;

public class HeronameCityDTO {
    private String heroName;
    private String city;

    public HeronameCityDTO(String heroName, String city) {
        this.heroName = heroName;
        this.city = city;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
