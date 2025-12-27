package com.myapp.model.shopping;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shopping_lists")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int list_id;

    @Column(name = "user_id")
    private int userId;

    @Column(nullable = false)
    private String name;

    private String status; // "Active" | "Archived" | "Completed"

    private LocalDate createdDate;

    public ShoppingList() {
        this.createdDate = LocalDate.now();
        this.status = "Active";
    }

    public ShoppingList(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.createdDate = LocalDate.now();
        this.status = "Active";
    }

    // --- Getters + Setters ---
    public int getList_id() { return list_id; }
    public void setList_id(int list_id) { this.list_id = list_id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
}