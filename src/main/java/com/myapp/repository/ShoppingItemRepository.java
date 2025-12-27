package com.myapp.repository;

import com.myapp.model.shopping.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Integer> {
    List<ShoppingItem> findByListId(int listId);
}