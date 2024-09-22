package com.simpletomate.repository;

import com.simpletomate.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository is an interface that provides access to data in a database
 */
public interface CategoryRepo extends JpaRepository<Category, Integer> {


    List<Category> findByNameContaining(String name);
}