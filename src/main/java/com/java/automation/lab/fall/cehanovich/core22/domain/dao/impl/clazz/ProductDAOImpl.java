package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Product;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ProductDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
    public synchronized Product create(Product product) {
        new ObjectIO<Product>().write(product, IOConstant.RQ_PATH);
        return product;
    }

    @Override
    public synchronized Product update(Product newProduct) {
        return new Product(newProduct.getId(), newProduct.getName(), newProduct.getBrand(),
                newProduct.getDescription(), newProduct.getVariation(), newProduct.getCreated(), newProduct.getModified());
    }

    @Override
    public Product getById(Long id) {
        return new ObjectIO<Product>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Product> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
