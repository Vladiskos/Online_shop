package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.SubcategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.SubcategoryDAOImpl;

import java.util.List;
import java.util.Set;

public class SubcategoryService extends BaseService{
    private static final SubcategoryDAO DAO = SUBCATEGORY_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static Subcategory createSubcategory(int id, int discount, String name, Set<Product> products) {
        return DAO.create(new Subcategory(id, discount, name, products));
    }

    public static Subcategory getSubcategoryById(Long id) {
        return DAO.getById(id);
    }

    public static List<Subcategory> get() {
        return DAO.get();
    }

    public static Subcategory update(Subcategory o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
