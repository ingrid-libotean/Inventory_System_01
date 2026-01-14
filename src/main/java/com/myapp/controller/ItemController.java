package com.myapp.controller;

import com.myapp.model.warehouse.Item;
import com.myapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // 1. Găsește toate itemele dintr-un depozit specific
    @GetMapping("/warehouse/{warehouseId}")
    public List<Item> getItemsByWarehouse(@PathVariable Integer warehouseId) {
        return itemRepository.findByWarehouseId(warehouseId);
    }

    // 2. Adauga un item nou
    @PostMapping("/add")
    public Item addItem(@RequestBody Item item) {
        // momentan doar salvăm
        return itemRepository.save(item);
    }

    // 3. Șterge un item
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return "Item deleted";
        }
        return "Item not found";
    }

    // 4. Update Item (pentru cantitate sau preț)
    @PutMapping("/update/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item updatedData) {
        return itemRepository.findById(id).map(item -> {
            item.setName(updatedData.getName());
            item.setCurrentQuantity(updatedData.getCurrentQuantity());
            item.setPrice(updatedData.getPrice());
            return itemRepository.save(item);
        }).orElse(null);
    }
}