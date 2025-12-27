package com.myapp.model.warehouse;

import javax.persistence.*; // Important pentru DB
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;

    @Column(name = "item_id")
    private int itemId; // Păstrăm simplu ca ID pentru moment

    @Column(name = "warehouse_id")
    private int warehouseId;

    private String type; // "Acquisition" | "Removal"
    private double quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    // Constructor gol obligatoriu pentru JPA
    public Transaction() {}

    public Transaction(int itemId, int warehouseId, String type, double quantity) {
        this.itemId = itemId;
        this.warehouseId = warehouseId;
        this.type = type;
        this.quantity = quantity;
        this.timestamp = new Date(); // Setează timpul curent automat
    }

    // --- Getters + Setters ---
    public int getTransaction_id() { return transaction_id; }
    public void setTransaction_id(int transaction_id) { this.transaction_id = transaction_id; }

    public int getItemId() { return itemId; }
    public void setItemId(int item_id) { this.itemId = item_id; }

    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouse_id) { this.warehouseId = warehouse_id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}