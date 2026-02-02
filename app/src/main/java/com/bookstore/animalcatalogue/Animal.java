package com.bookstore.animalcatalogue;

public class Animal {
    private String name;
    private String scientificName;
    private String description;
    private String habitat;
    private String funFact;
    private int imageResId;
    private AnimalCategory category;

    public Animal(String name, String scientificName, String description,
                  String habitat, String funFact, int imageResId, AnimalCategory category) {
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
        this.habitat = habitat;
        this.funFact = funFact;
        this.imageResId = imageResId;
        this.category = category;
    }

    public String getName() { return name; }
    public String getScientificName() { return scientificName; }
    public String getDescription() { return description; }
    public String getHabitat() { return habitat; }
    public String getFunFact() { return funFact; }
    public int getImageResId() { return imageResId; }
    public AnimalCategory getCategory() { return category; }
}