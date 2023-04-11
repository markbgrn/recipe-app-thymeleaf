package com.groupone.recipeappbackend.recipe.controller;

import com.groupone.recipeappbackend.recipe.dto.RecipeDto;
import com.groupone.recipeappbackend.recipe.model.Recipe;
import com.groupone.recipeappbackend.recipe.service.RecipeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public String listRecipes(Model model) {
        List<RecipeDto> recipes = recipeService.findAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

    @GetMapping("/recipes/{id}")
    public String recipeDetail(@PathVariable("id")Long id, Model model){
        RecipeDto recipeDto = recipeService.findRecipeById(id);
        model.addAttribute("recipe", recipeDto);
        return "recipe-detail";
    }

    @GetMapping("/recipes/new")
    public String createRecipeForm(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipe-create";
    }

    @PostMapping("/recipes/new")
    public String saveRecipe(@Valid @ModelAttribute("recipe") RecipeDto recipeDto, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("recipe",recipeDto);
            return "recipe-create";
        }
        recipeService.saveRecipe(recipeDto);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/{id}/edit")
    public String updateRecipeForm(@PathVariable("id") Long id, Model model) {
        RecipeDto recipeDto = recipeService.findRecipeById(id);
        model.addAttribute("recipe", recipeDto);
        return "recipe-edit";
    }

    @PostMapping("/recipes/{id}/edit")
    public String updateRecipe(@PathVariable("id") Long id, @Valid
                                @ModelAttribute("recipe") RecipeDto recipeDto,
                               BindingResult result) {
        if(result.hasErrors())
        {
            return "recipe-edit";
        }
        recipeDto.setId(id);
        recipeService.updateRecipe(recipeDto);
        return "redirect:/recipes";
    }
}
