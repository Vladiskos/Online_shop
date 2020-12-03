package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Subcategory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.SubcategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
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
    public Subcategory create(Subcategory o) {
        try {
            new JsonIO<>(Subcategory.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Subcategory getById(Long id) {
        try {
            return new JsonIO<>(Subcategory.class).read(String.format(IOConstant.JSON_OBJ_PATH, Subcategory.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Subcategory> get() {
        return null;
    }

    @Override
    public Subcategory update(Subcategory o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
