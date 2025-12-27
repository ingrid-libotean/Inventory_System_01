package com.myapp.repository;

import com.myapp.model.shopping.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
    List<ShoppingList> findByUserId(int userId);
}