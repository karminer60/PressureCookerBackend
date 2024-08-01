package com.simpletomate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * An entity class represents a table in a relational database
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    private Integer id;
    private String title;
    private String body;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}