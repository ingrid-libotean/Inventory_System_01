package com.myapp.controller;

import com.myapp.model.users.User;
import com.myapp.model.warehouse.Warehouse;
import com.myapp.repository.UserRepository;
import com.myapp.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouses")
@CrossOrigin(origins = "*")
public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private UserRepository userRepository;

    // 1. Obține toate depozitele pentru un user specific (după email)
    @GetMapping("/user/{email}")
    public List<Warehouse> getUserWarehouses(@PathVariable String email) {
        // Căutăm ID-ul userului bazat pe email
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return warehouseRepository.findByUserId(user.get().getUser_id());
        }
        return List.of(); // Returnează listă goală dacă nu găsește userul
    }

    // 2. Adaugă un depozit nou
    @PostMapping("/add")
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse, @RequestParam String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            warehouse.setUser_id(user.get().getUser_id());
            return warehouseRepository.save(warehouse);
        }
        throw new RuntimeException("User not found");
    }

    // 3. UPDATE (Modifică un depozit existent)
    @PutMapping("/update/{id}")
    public Warehouse updateWarehouse(@PathVariable int id, @RequestBody Warehouse updatedData) {
        return warehouseRepository.findById(id)
                .map(warehouse -> {
                    warehouse.setName(updatedData.getName());
                    warehouse.setLocation(updatedData.getLocation());
                    return warehouseRepository.save(warehouse);
                })
                .orElseThrow(() -> new RuntimeException("Warehouse not found with id " + id));
    }

    // 4. DELETE (Șterge un depozit)
    @DeleteMapping("/delete/{id}")
    public String deleteWarehouse(@PathVariable int id) {
        if (warehouseRepository.existsById(id)) {
            warehouseRepository.deleteById(id);
            return "Warehouse deleted successfully";
        }
        return "Error: Warehouse not found";
    }
}