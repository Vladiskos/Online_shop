package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Subcategory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.SubcategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
        new ObjectIO<Subcategory>().write(subcategory, IOConstant.RQ_PATH);
        return subcategory;
    }

    @Override
    public synchronized Subcategory update(Subcategory newSubcategory) {
        return new Subcategory(newSubcategory.getId(), newSubcategory.getDiscountPercent(), newSubcategory.getName(),
                newSubcategory.getProducts());
    }

    @Override
    public Subcategory getById(Long id) {
        return new ObjectIO<Subcategory>().read(IOConstant.RQ_PATH);
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
