package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Basket;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BasketDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
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
    public Basket create(Basket o) {
        try {
            new JsonIO<>(Basket.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Basket getById(Long id) {
        try {
            return new JsonIO<>(Basket.class).read(String.format(IOConstant.JSON_OBJ_PATH, Basket.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Basket> get() {
        return null;
    }

    @Override
    public Basket update(Basket o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
