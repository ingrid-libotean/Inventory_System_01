package com.myapp.model.warehouse;

import javax.persistence.*;
// import java.util.List; // O vom reactiva când facem clasa Item

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouse_id;

    @Column(nullable = false)
    private int userId; // Legătura cu User-ul (Foreign Key simplificat)

    @Column(nullable = false)
    private String name;

    private String location;

    // Momentan comentăm lista până transformăm și clasa 'Item' în Entity
    // @OneToMany(mappedBy = "warehouse")
    // private List<Item> items;

    public Warehouse() {}

    public Warehouse(int userId, String name, String location) {
        this.userId = userId;
        this.name = name;
        this.location = location;
    }

    // --- Getters & Setters ---
    public int getWarehouse_id() { return warehouse_id; }
    public void setWarehouse_id(int warehouse_id) { this.warehouse_id = warehouse_id; }

    public int getUser_id() { return userId; }
    public void setUser_id(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}