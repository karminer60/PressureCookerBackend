package com.simpletomate.repository;

import com.simpletomate.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository is an interface that provides access to data in a database
 */
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByPublished(boolean published);

    List<Recipe> findByTitleContaining(String title);
}
