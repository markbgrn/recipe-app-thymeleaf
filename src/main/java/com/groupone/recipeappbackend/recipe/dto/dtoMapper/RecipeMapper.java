package com.groupone.recipeappbackend.recipe.dto.dtoMapper;

import com.groupone.recipeappbackend.recipe.dto.RecipeDto;
import com.groupone.recipeappbackend.recipe.model.Recipe;

public class RecipeMapper {
    public static RecipeDto mapToRecipeDto(Recipe recipe){
        RecipeDto recipeDto = RecipeDto.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .photoUrl(recipe.getPhotoUrl())
                .ingredients(recipe.getIngredients())
                .procedure(recipe.getProcedure())
                .description(recipe.getDescription())
                .createdOn(recipe.getCreatedOn())
                .updatedOn(recipe.getUpdatedOn())
                .build();
        return recipeDto;
    }
}
