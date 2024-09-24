package com.simpletomate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    public Set<Recipe> getRecipes(){
        return this.recipes;

    }

    public void addRecipe(Recipe r) {
        this.recipes.add(r);
        r.getCategories().add(this);
    }

    public void removeRecipe(Recipe r) {
        this.recipes.remove(r);
        r.getCategories().remove(this);
    }

    @ManyToMany(mappedBy ="categories")
    private Set<Recipe> recipes = new HashSet<Recipe>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;


    public Category() {

    }

    public Category(String name) {
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name +  "]";
    }

}
