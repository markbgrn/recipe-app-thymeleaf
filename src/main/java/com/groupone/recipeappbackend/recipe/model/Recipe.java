package com.groupone.recipeappbackend.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    @Column(name = "recipe_title")
    private String title;
    @Column(name = "recipe_photo")
    private String photoUrl;
    @Column(name = "recipe_ingredients")
    private String ingredients;
    @Column(name = "recipe_procedure")
    private String procedure;
    @Column(name = "description")
    private String description;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
