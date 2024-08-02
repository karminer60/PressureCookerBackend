package com.simpletomate.controllers;

import com.simpletomate.models.Recipe;
import com.simpletomate.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class is where all the user requests are handled and required/appropriate
 * responses are sent
 */
@RestController
@RequestMapping("/recipe/v1")
@RequiredArgsConstructor
@Validated
public class RecipeController {

    private final RecipeService recipeService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Fetches all the employees in the employee table
     * @return List of Employees
     */
    @GetMapping("/")
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return ResponseEntity.ok().body(recipeService.getAllRecipes());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Fetches employee with the given id
     * @param id - employee id
     * @return Employee with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(recipeService.getRecipeById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Save an Employee entity
     * @param recipe - Request body is an Employee entity
     * @return Saved Employee entity
     */
    @PostMapping("/")
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe)
    {
        return ResponseEntity.ok().body(recipeService.saveRecipe(recipe));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Update an Employee entity
     * @param recipe - Employee entity to be updated
     * @return Updated Employee
     */
    @PutMapping("/")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe)
    {
        return ResponseEntity.ok().body(recipeService.updateRecipe(recipe));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Delete an Employee entity
     * @param id - employee's id to be deleted
     * @return a String message indicating employee record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipeById(@PathVariable Integer id)
    {
        recipeService.deleteRecipeById(id);
        return ResponseEntity.ok().body("Deleted recipe successfully");
    }


}