package com.example.apimongopeticos.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personalization")
public class Personalization {

    @Id
    private Long id; // id do pet
    private String species; // "cat" or "dog"
    private Integer hatId; // id do chapéu
    private Integer hairId; // id cor do pet
    private Integer toyId; // id do brinquedo
    private Integer glassesId; // id do óculos

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getHatId() {
        return hatId;
    }

    public void setHatId(Integer hatId) {
        this.hatId = hatId;
    }

    public Integer getHairId() {
        return hairId;
    }

    public void setHairId(Integer hairId) {
        this.hairId = hairId;
    }

    public Integer getToyId() {
        return toyId;
    }

    public void setToyId(Integer toyId) {
        this.toyId = toyId;
    }

    public Integer getGlassesId() {
        return glassesId;
    }

    public void setGlassesId(Integer glassesId) {
        this.glassesId = glassesId;
    }
}
