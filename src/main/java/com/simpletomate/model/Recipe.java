package com.simpletomate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Table(name = "recipes")
public class Recipe {
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = {@JoinColumn(name = "fk_recipe")},
            inverseJoinColumns = {@JoinColumn(name = "fk_category")})
    private Set<Category> categories = new HashSet<Category>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @Column(name = "fk_category")
    private String fk_category;


    public Recipe() {

    }

    public Recipe(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }

}
