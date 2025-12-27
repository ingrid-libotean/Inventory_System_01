package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.warehouse.Item;
import java.util.List;

public interface ItemDAO {
    void create(Item item) throws DuplicateEntryException;
    Item findById(int id) throws DataNotFoundException;
    List<Item> findAll();
    void update(Item item) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
