
package com.simpletomate.services;

import com.simpletomate.models.Recipe;
import com.simpletomate.repositories.RecipeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service layer is where all the business logic lies
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {

    private final RecipeRepo recipeRepo;

    public List<Recipe> getAllRecipes(){
        return recipeRepo.findAll();
    }

    public Recipe getRecipeById(Integer id){
        Optional<Recipe> optionalRecipe = recipeRepo.findById(id);
        if(optionalRecipe.isPresent()){
            return optionalRecipe.get();
        }
        log.info("Recipe with id: {} doesn't exist", id);
        return null;
    }

    public Recipe saveRecipe (Recipe recipe){
        recipe.setCreatedAt(LocalDateTime.now());
        recipe.setUpdatedAt(LocalDateTime.now());
        Recipe savedRecipe = recipeRepo.save(recipe);

        log.info("Recipe with id: {} saved successfully", recipe.getId());
        return savedRecipe;
    }

    public Recipe updateRecipe (Recipe recipe) {
        Optional<Recipe> existingEmployee = recipeRepo.findById(recipe.getId());
        recipe.setCreatedAt(existingEmployee.get().getCreatedAt());
        recipe.setUpdatedAt(LocalDateTime.now());

        Recipe updatedRecipe = recipeRepo.save(recipe);

        log.info("Recipe with id: {} updated successfully", recipe.getId());
        return updatedRecipe;
    }

    public void deleteRecipeById (Integer id) {
        recipeRepo.deleteById(id);
    }

}
