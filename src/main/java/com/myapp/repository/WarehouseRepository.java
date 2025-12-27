package com.myapp.repository;

import com.myapp.model.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    // Ne va ajuta să găsim toate depozitele unui singur user
    List<Warehouse> findByUserId(int userId);
}