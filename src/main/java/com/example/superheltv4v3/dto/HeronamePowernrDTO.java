package com.example.superheltv4v3.dto;

public class HeronamePowernrDTO {
    private String heroName;
    private int numberOfPowers;

    public HeronamePowernrDTO(String heroName, int numberOfPowers) {
        this.heroName = heroName;
        this.numberOfPowers = numberOfPowers;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getNumberOfPowers() {
        return numberOfPowers;
    }

    public void setNumberOfPowers(int numberOfPowers) {
        this.numberOfPowers = numberOfPowers;
    }
}
