package com.groupone.recipeappbackend.recipe.implementation;

import com.groupone.recipeappbackend.recipe.dto.RecipeDto;
import com.groupone.recipeappbackend.recipe.model.Recipe;
import com.groupone.recipeappbackend.recipe.repository.RecipeRepository;
import com.groupone.recipeappbackend.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.groupone.recipeappbackend.recipe.dto.dtoMapper.RecipeMapper.mapToRecipeDto;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDto> findAllRecipes() {
       List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map((club) -> mapToRecipeDto(club)).collect(Collectors.toList());
    }

    @Override
    public Recipe saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = mapToRecipe(recipeDto);
        return recipeRepository.save(recipe);
    }

    @Override
    public RecipeDto findRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        return mapToRecipeDto(recipe);
    }

    @Override
    public void updateRecipe(RecipeDto recipeDto) {
        Recipe recipe = mapToRecipe(recipeDto);
        recipeRepository.save(recipe);
    }

    @Override
    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }

    private Recipe mapToRecipe(RecipeDto recipe) {
        Recipe recipeDto = Recipe.builder()
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
