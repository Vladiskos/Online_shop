package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Basket;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BasketDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

import java.util.List;

public class BasketDAOImpl implements BasketDAO{
    private static BasketDAOImpl instance;

    public static synchronized BasketDAOImpl getInstance() {
        if (instance==null) {
            instance = new BasketDAOImpl();
            System.out.println();
        }
        return instance;
    }

    private BasketDAOImpl() {

    }

    @Override
    public synchronized Basket create(Basket basket) {
        new ObjectIO<Basket>().write(basket, IOConstant.RQ_PATH);
        return basket;
    }

    @Override
    public synchronized Basket update(Basket newBasket) {
        return new Basket(newBasket.getId(), newBasket.getVariations(), newBasket.getTotalPrice(),
                newBasket.getBankCard(), newBasket.getPriceBook(),newBasket.getCoupon(), newBasket.getUser(),
                newBasket.getCreated(), newBasket.getModified());
    }

    @Override
    public Basket getById(Long id) {
        return new ObjectIO<Basket>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Basket> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
