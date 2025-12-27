package com.myapp.model.shopping;

import javax.persistence.*;

@Entity
@Table(name = "shopping_items")
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;

    @Column(name = "list_id")
    private int listId; // Legătura cu lista părinte

    private String name;
    private int quantity;

    private boolean isChecked; // Aici salvăm dacă e tăiat de pe listă sau nu

    public ShoppingItem() {}

    public ShoppingItem(int listId, String name, int quantity) {
        this.listId = listId;
        this.name = name;
        this.quantity = quantity;
        this.isChecked = false; // Implicit nu e cumpărat
    }

    // --- Getters + Setters ---
    public int getItem_id() { return item_id; }
    public void setItem_id(int item_id) { this.item_id = item_id; }

    public int getListId() { return listId; }
    public void setListId(int listId) { this.listId = listId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isChecked() { return isChecked; }
    public void setChecked(boolean checked) { isChecked = checked; }
}