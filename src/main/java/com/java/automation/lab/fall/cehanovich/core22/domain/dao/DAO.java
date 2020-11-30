package com.java.automation.lab.fall.cehanovich.core22.domain.dao;

import java.util.List;

public interface DAO<T> {
    T create(T o);
    T getById(Long id);
    List<T> get();
    T update(T o);
    void deleteById(Long id);
}
