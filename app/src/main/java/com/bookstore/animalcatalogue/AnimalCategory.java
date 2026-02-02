package com.bookstore.animalcatalogue;

public enum AnimalCategory {
    MAMMALS("Mammals"),
    AQUATIC("Aquatic");

    private final String displayName;

    AnimalCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}