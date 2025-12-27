package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.shopping.ShoppingItem;
import java.util.List;

public interface ShoppingListItemDAO {

    void create(ShoppingItem item) throws DuplicateEntryException;
    ShoppingItem findById(int id) throws DataNotFoundException;
    List<ShoppingItem> findAll();
    //List<ShoppingListItem> getByCategory(int categoryId);
    List<ShoppingItem> findByList(int listId);
    void update(ShoppingItem item) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
