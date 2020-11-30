package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Category;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Subcategory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.CategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.CategoryDAOImpl;

import java.util.List;
import java.util.Set;

public class CategoryService extends BaseService{
    private static final CategoryDAO DAO = CATEGORY_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    public static Category createCategoryInfo(int id, Set<Subcategory> subcategories, String name) {
        return DAO.create(new Category(id, subcategories, name));
    }

    public static Category getCategoryById(Long id) {
        return DAO.getById(id);
    }

    public static List<Category> get() {
        return DAO.get();
    }

    public static Category update(Category o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
