package com.myapp.dao;

import java.util.List;

public interface SearchDAO<T> {
    List<T> searchByName(String name);
}
