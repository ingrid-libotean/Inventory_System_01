package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.warehouse.Warehouse;
import java.util.List;

public interface WarehouseDAO {
    void create(Warehouse warehouse) throws DuplicateEntryException;
    Warehouse findById(int id) throws DataNotFoundException;
    List<Warehouse> findAll();
    void update(Warehouse warehouse) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
