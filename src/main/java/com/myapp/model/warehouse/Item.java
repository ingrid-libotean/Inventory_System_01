package com.myapp.model.warehouse;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(nullable = false)
    private String name;

    @Column(name = "current_quantity")
    private double currentQuantity;

    private double price;
    private double weight;
    private double volume;

    // Listele de tranzacții le gestionăm prin Repository, nu direct în Entitate momentan
    // pentru a evita erori de "Lazy Loading" sau bucle infinite.

    public Item() {}

    public Item(Integer userId, Integer warehouseId, Integer categoryId, String name,
                double currentQuantity, double price, double weight, double volume) {
        this.userId = userId;
        this.warehouseId = warehouseId;
        this.categoryId = categoryId;
        this.name = name;
        this.currentQuantity = currentQuantity;
        this.price = price;
        this.weight = weight;
        this.volume = volume;
    }

    // --- Getters + Setters ---

    public int getItem_id() { return item_id; }
    public void setItem_id(int item_id) { this.item_id = item_id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getWarehouseId() { return warehouseId; }
    public void setWarehouseId(Integer warehouseId) { this.warehouseId = warehouseId; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCurrentQuantity() { return currentQuantity; }
    public void setCurrentQuantity(double currentQuantity) { this.currentQuantity = currentQuantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }
}