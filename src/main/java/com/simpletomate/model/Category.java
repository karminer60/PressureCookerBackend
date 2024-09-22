package com.simpletomate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
   @ManyToMany(mappedBy ="categories")
    private Set<Recipe> recipes = new HashSet<Recipe>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fk_recipe")
    private String fk_recipe;


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
