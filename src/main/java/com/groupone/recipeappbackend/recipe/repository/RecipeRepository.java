package com.groupone.recipeappbackend.recipe.repository;

import com.groupone.recipeappbackend.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
