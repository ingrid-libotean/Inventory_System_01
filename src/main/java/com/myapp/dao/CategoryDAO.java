package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.shopping.Category;
import java.util.List;

public interface CategoryDAO {
    void create(Category category) throws DuplicateEntryException;
    Category getById(int id) throws DataNotFoundException;
    List<Category> getAll();
    List<Category> findByList(int listId);
    void update(Category category) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
