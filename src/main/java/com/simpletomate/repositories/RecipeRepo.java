package com.simpletomate.repositories;

import com.simpletomate.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
/**
 * Repository is an interface that provides access to data in a database
 */
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
}
