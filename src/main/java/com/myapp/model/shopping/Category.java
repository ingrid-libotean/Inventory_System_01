package com.myapp.model.shopping;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    @Column(name = "list_id")
    private int listId; // ID-ul listei de cumpărături de care aparține

    @Column(nullable = false)
    private String name;

    private String type; // "Shop" | "Tier" | "Custom"

    public Category() {}

    public Category(int listId, String name, String type) {
        this.listId = listId;
        this.name = name;
        this.type = type;
    }

    // --- Getters + Setters ---

    public int getCategory_id() { return category_id; }
    public void setCategory_id(int category_id) { this.category_id = category_id; }

    public int getListId() { return listId; }
    public void setListId(int listId) { this.listId = listId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}