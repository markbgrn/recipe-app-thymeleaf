package com.groupone.recipeappbackend.recipe.dto;

import lombok.Builder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
public class RecipeDto {
    private Long id;
    @NotEmpty(message = "Recipe title should not be blank.")
    private String title;
    @NotEmpty(message = "Recipe url should not be blank.")
    private String photoUrl;
    @NotEmpty(message = "Recipe ingredients should not be blank.")
    private String ingredients;
    @NotEmpty(message = "Recipe procedure should not be blank.")
    private String procedure;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
