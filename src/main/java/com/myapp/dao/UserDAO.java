package com.myapp.dao;

import com.myapp.exceptions.DataNotFoundException;
import com.myapp.exceptions.DuplicateEntryException;
import com.myapp.model.users.User;

import java.util.List;

public interface UserDAO {
    void create(User user) throws DuplicateEntryException;
    User findById(int id) throws DataNotFoundException;
    User findByEmail(String email) throws DataNotFoundException;
    boolean existsByEmail(String email);
    List<User> findAll();
    void update(User user) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
