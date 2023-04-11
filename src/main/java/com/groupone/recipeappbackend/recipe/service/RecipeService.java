package com.groupone.recipeappbackend.recipe.service;

import com.groupone.recipeappbackend.recipe.dto.RecipeDto;
import com.groupone.recipeappbackend.recipe.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RecipeService {
    List<RecipeDto> findAllRecipes();

    Recipe saveRecipe(RecipeDto recipeDto);

    RecipeDto findRecipeById(Long id);

    void updateRecipe(RecipeDto recipeDto);
}
