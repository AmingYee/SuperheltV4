package com.example.superheltv4v3.dto;

public class HeronamePowerDTO {
    private String heroName;
    private String superPower;

    public HeronamePowerDTO(String heroName, String superPower) {
        this.heroName = heroName;
        this.superPower = superPower;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
