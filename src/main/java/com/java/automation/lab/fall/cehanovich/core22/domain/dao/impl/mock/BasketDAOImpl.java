package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BasketDAO;

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
        return basket;
    }

    @Override
    public synchronized Basket update(Basket newBasket) {
        return new Basket(newBasket.getId(), newBasket.getVariations(), newBasket.getTotalPrice(),
                newBasket.getBankCard(), newBasket.getPriceBook(),newBasket.getCoupon(), newBasket.getUser()
                , newBasket.getCreated(), newBasket.getModified());
    }

    @Override
    public Basket getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
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
