package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.shopping.ShoppingList;
import java.util.List;

public interface ShoppingListDAO {
    void create(ShoppingList list) throws DuplicateEntryException;
    ShoppingList findById(int id) throws DataNotFoundException;
    List<ShoppingList> findAll();
    //findbyuser - neimplementat
    List<ShoppingList> findByUser(int userId);
    void update(ShoppingList list) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}

