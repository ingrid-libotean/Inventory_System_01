package com.myapp.repository;

import com.myapp.model.warehouse.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // This empty interface automatically gives you:
    // save(), findAll(), findById(), delete()
    // No code needed!

    // Example custom query: Find all transactions for a specific item
    // List<Transaction> findByItemId(int itemId);
}