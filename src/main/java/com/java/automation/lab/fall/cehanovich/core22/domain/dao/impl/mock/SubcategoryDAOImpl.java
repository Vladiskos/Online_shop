package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.SubcategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;

import java.util.List;

public class SubcategoryDAOImpl implements SubcategoryDAO {
    private static SubcategoryDAOImpl instance;

    public synchronized static SubcategoryDAOImpl getInstance() {
        if (instance==null) {
            instance = new SubcategoryDAOImpl();
        }
        return instance;
    }

    private SubcategoryDAOImpl() {

    }

    @Override
    public synchronized Subcategory create(Subcategory subcategory) {
        return subcategory;
    }

    @Override
    public synchronized Subcategory update(Subcategory newSubcategory) {
        return new Subcategory(newSubcategory.getId(), newSubcategory.getDiscountPercent(), newSubcategory.getName(),
                newSubcategory.getProducts());
    }

    @Override
    public Subcategory getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<Subcategory> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
