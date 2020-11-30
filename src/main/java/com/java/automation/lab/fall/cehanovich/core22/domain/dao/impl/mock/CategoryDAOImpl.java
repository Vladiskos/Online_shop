package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Category;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.CategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static CategoryDAOImpl instance;

    public synchronized static CategoryDAOImpl getInstance() {
        if (instance==null) {
            instance = new CategoryDAOImpl();
        }
        return instance;
    }

    private CategoryDAOImpl() {

    }

    @Override
    public synchronized Category create(Category category) {
        return category;
    }

    @Override
    public synchronized Category update(Category newCategory) {
        return new Category(newCategory.getId(), newCategory.getSubcategories(), newCategory.getName());
    }

    @Override
    public Category getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<Category> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
