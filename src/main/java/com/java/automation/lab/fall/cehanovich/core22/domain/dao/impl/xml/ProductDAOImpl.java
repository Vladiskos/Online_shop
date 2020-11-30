package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Product;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ProductDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;

import javax.xml.bind.JAXBException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static ProductDAOImpl instance;

    public synchronized static ProductDAOImpl getInstance() {
        if (instance==null) {
            instance = new ProductDAOImpl();
        }
        return instance;
    }

    private ProductDAOImpl() {

    }

    @Override
    public Product create(Product o) {
        try {
            new XMLIO<>(Product.class).write(o, String.format(IOConstant.XML_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Product getById(Long id) {
        try {
            return new XMLIO<>(Product.class).read(String.format(IOConstant.XML_OBJ_PATH, Product.class.getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> get() {
        return null;
    }

    @Override
    public Product update(Product o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
