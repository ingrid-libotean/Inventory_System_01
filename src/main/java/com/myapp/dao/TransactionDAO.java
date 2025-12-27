package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.warehouse.Transaction;
import java.util.List;

public interface TransactionDAO {
    void create(Transaction transaction) throws DuplicateEntryException;
    Transaction findById(int id) throws DataNotFoundException;
    List<Transaction> findAll();
    void update(Transaction transaction) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;

}
