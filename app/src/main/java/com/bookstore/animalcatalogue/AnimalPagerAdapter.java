package com.bookstore.animalcatalogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnimalPagerAdapter extends RecyclerView.Adapter<AnimalPagerAdapter.AnimalViewHolder> {

    private List<Animal> animals;

    public AnimalPagerAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.animalImage.setImageResource(animal.getImageResId());
        holder.animalTitle.setText("Animal Catalogue: " + animal.getName());
        holder.scientificName.setText(animal.getScientificName());
        holder.animalDescription.setText(animal.getDescription());
        holder.habitatText.setText("Habitat: " + animal.getHabitat());
        holder.funFactText.setText("💡 Fun Fact: " + animal.getFunFact());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public void updateAnimals(List<Animal> newAnimals) {
        this.animals = newAnimals;
        notifyDataSetChanged();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView animalImage;
        TextView animalTitle;
        TextView scientificName;
        TextView animalDescription;
        TextView habitatText;
        TextView funFactText;

        AnimalViewHolder(View view) {
            super(view);
            animalImage = view.findViewById(R.id.animalImage);
            animalTitle = view.findViewById(R.id.animalTitle);
            scientificName = view.findViewById(R.id.scientificName);
            animalDescription = view.findViewById(R.id.animalDescription);
            habitatText = view.findViewById(R.id.habitatText);
            funFactText = view.findViewById(R.id.funFactText);
        }
    }
}