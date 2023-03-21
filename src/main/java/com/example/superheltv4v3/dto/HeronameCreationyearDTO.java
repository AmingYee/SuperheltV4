package com.example.superheltv4v3.dto;

public class HeronameCreationyearDTO {
    private int id;
    private String heroName;
    private int creationYear;

    public HeronameCreationyearDTO(int id, String heroName, int creationYear) {
        this.id = id;
        this.heroName = heroName;
        this.creationYear = creationYear;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
