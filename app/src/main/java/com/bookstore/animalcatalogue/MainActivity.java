package com.bookstore.animalcatalogue;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.bookstore.animalcatalogue.databinding.ActivityMainBinding;
import com.google.android.material.chip.Chip;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnimalPagerAdapter adapter;
    private List<Animal> currentAnimals;
    private AnimalCategory selectedCategory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize with all animals
        currentAnimals = AnimalRepository.getAllAnimals();
        adapter = new AnimalPagerAdapter(currentAnimals);
        binding.viewPager.setAdapter(adapter);

        setupCategoryChips();
        setupIconNavigation();
        setupNavigationButtons();
        setupPageChangeListener();
    }

    private void setupCategoryChips() {
        // Add "All" chip
        Chip allChip = new Chip(this);
        allChip.setText("All Animals");
        allChip.setCheckable(true);
        allChip.setChecked(true);
        allChip.setOnClickListener(v -> {
            selectedCategory = null;
            updateAnimalList();
        });
        binding.categoryChipGroup.addView(allChip);

        // Add category chips
        for (AnimalCategory category : AnimalRepository.getCategories()) {
            Chip chip = new Chip(this);
            chip.setText(category.getDisplayName());
            chip.setCheckable(true);
            chip.setOnClickListener(v -> {
                selectedCategory = category;
                updateAnimalList();
            });
            binding.categoryChipGroup.addView(chip);
        }
    }

    private void updateAnimalList() {
        if (selectedCategory == null) {
            currentAnimals = AnimalRepository.getAllAnimals();
        } else {
            currentAnimals = AnimalRepository.getAnimalsByCategory(selectedCategory);
        }

        adapter.updateAnimals(currentAnimals);
        binding.viewPager.setCurrentItem(0, true);
        setupIconNavigation();
    }

    private void setupIconNavigation() {
        binding.iconContainer.removeAllViews();

        for (int i = 0; i < currentAnimals.size(); i++) {
            final int index = i;
            Animal animal = currentAnimals.get(i);

            ImageView iconView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(120, 120);
            params.setMarginEnd(16);
            iconView.setLayoutParams(params);
            iconView.setImageResource(animal.getImageResId());
            iconView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iconView.setPadding(8, 8, 8, 8);
            iconView.setBackground(ContextCompat.getDrawable(
                    this,
                    index == 0 ? R.drawable.icon_selected : R.drawable.icon_background
            ));

            iconView.setOnClickListener(v ->
                    binding.viewPager.setCurrentItem(index, true)
            );

            binding.iconContainer.addView(iconView);
        }
    }

    private void setupNavigationButtons() {
        binding.btnPrevious.setOnClickListener(v -> {
            int currentItem = binding.viewPager.getCurrentItem();
            if (currentItem > 0) {
                binding.viewPager.setCurrentItem(currentItem - 1, true);
            }
        });

        binding.btnNext.setOnClickListener(v -> {
            int currentItem = binding.viewPager.getCurrentItem();
            if (currentItem < currentAnimals.size() - 1) {
                binding.viewPager.setCurrentItem(currentItem + 1, true);
            }
        });
    }

    private void setupPageChangeListener() {
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateIconSelection(position);
                updateNavigationButtons(position);
            }
        });
    }

    private void updateIconSelection(int position) {
        for (int i = 0; i < binding.iconContainer.getChildCount(); i++) {
            ImageView iconView = (ImageView) binding.iconContainer.getChildAt(i);
            iconView.setBackground(ContextCompat.getDrawable(
                    this,
                    i == position ? R.drawable.icon_selected : R.drawable.icon_background
            ));
        }
    }

    private void updateNavigationButtons(int position) {
        binding.btnPrevious.setEnabled(position > 0);
        binding.btnNext.setEnabled(position < currentAnimals.size() - 1);

        binding.btnPrevious.setAlpha(position > 0 ? 1.0f : 0.5f);
        binding.btnNext.setAlpha(position < currentAnimals.size() - 1 ? 1.0f : 0.5f);
    }
}