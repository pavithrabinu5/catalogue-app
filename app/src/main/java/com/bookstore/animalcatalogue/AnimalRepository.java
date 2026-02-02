package com.bookstore.animalcatalogue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalRepository {
    private static List<Animal> animals;

    static {
        animals = new ArrayList<>();

        animals.add(new Animal(
                "Fox",
                "Vulpes vulpes",
                "Foxes are intelligent, adaptable mammals known for their sharp senses and clever behavior. They have slender bodies, pointed snouts, upright ears, and thick bushy tails, allowing them to thrive in a wide variety of environments.",
                "Forests, grasslands, mountains, and deserts across the Northern Hemisphere",
                "Foxes use Earth's magnetic field to hunt! They can detect small animals under the snow.",
                R.drawable.fox,
                AnimalCategory.MAMMALS
        ));

        animals.add(new Animal(
                "Hedgehog",
                "Erinaceinae",
                "Hedgehogs are small nocturnal mammals covered in thousands of sharp spines for protection. When threatened, they roll into a tight ball, exposing only their spines and hiding their soft underside.",
                "Gardens, woodlands, grasslands in Europe, Asia, and Africa",
                "Hedgehogs have existed for over 15 million years, making them one of the oldest mammal groups!",
                R.drawable.hedgehog,
                AnimalCategory.MAMMALS
        ));

        animals.add(new Animal(
                "Otter",
                "Lutrinae",
                "Otters are energetic, semi-aquatic mammals with streamlined bodies, webbed feet, and thick fur that keeps them warm in cold water. They are highly social and known for playful behavior.",
                "Rivers, lakes, and coastal waters worldwide",
                "Sea otters hold hands while sleeping to prevent drifting apart!",
                R.drawable.otter,
                AnimalCategory.AQUATIC
        ));

        animals.add(new Animal(
                "Red Panda",
                "Ailurus fulgens",
                "Red pandas are shy, tree-dwelling mammals with soft reddish fur, white facial markings, and long, fluffy tails that help with balance and warmth in cold mountain forests.",
                "Temperate forests in the Himalayas and mountains of China",
                "Red pandas use their bushy tails as blankets during cold nights!",
                R.drawable.red_panda,
                AnimalCategory.MAMMALS
        ));

        animals.add(new Animal(
                "Beluga Whale",
                "Delphinapterus leucas",
                "Beluga whales are small, white Arctic whales with rounded foreheads called melons. They are extremely social and communicate using clicks, whistles, and chirps, earning them the nickname 'canaries of the sea.'",
                "Arctic and sub-Arctic waters",
                "Belugas can swim backward and produce the widest variety of sounds of any whale!",
                R.drawable.beluga_whale,
                AnimalCategory.AQUATIC
        ));

        animals.add(new Animal(
                "Snow Leopard",
                "Panthera uncia",
                "Snow leopards are rare and powerful big cats perfectly adapted to freezing mountain habitats. Their thick fur, wide paws, and long tails help them balance and survive in steep, rocky terrain.",
                "Mountain ranges of Central and South Asia",
                "A snow leopard’s tail can wrap around its body like a scarf to conserve heat!",
                R.drawable.snow_leopard,
                AnimalCategory.MAMMALS
        ));

        animals.add(new Animal(
                "Axolotl",
                "Ambystoma mexicanum",
                "Axolotls are unusual aquatic salamanders that never undergo full metamorphosis, allowing them to stay underwater for life while retaining larval features like external gills.",
                "Freshwater lakes and canals of Mexico",
                "Axolotls can regrow limbs, organs, spinal cord tissue, and even parts of their brain!",
                R.drawable.axolotl,
                AnimalCategory.AQUATIC
        ));

    }

    public static List<Animal> getAllAnimals() {
        return new ArrayList<>(animals);
    }

    public static List<Animal> getAnimalsByCategory(AnimalCategory category) {
        List<Animal> filtered = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getCategory() == category) {
                filtered.add(animal);
            }
        }
        return filtered;
    }

    public static List<AnimalCategory> getCategories() {
        return Arrays.asList(AnimalCategory.values());
    }
}