package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Product;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ProductDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.ProductDAOImpl;

import java.util.List;

public class ProductService extends BaseService{
    private static final ProductDAO DAO = PRODUCT_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    public static Product createProductBook(int code, String name, String brand, String description) {
        return DAO.create(new Product(code, name, brand, description));
    }

    public static Product getProductById(Long id) {
        return DAO.getById(id);
    }

    public static List<Product> get() {
        return DAO.get();
    }

    public static Product update(Product o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
