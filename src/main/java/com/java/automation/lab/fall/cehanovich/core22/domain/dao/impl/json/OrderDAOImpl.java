package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Order;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.OrderDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static OrderDAOImpl instance;

    public synchronized static OrderDAOImpl getInstance() {
        if (instance==null) {
            instance = new OrderDAOImpl();
        }
        return instance;
    }

    private OrderDAOImpl() {

    }

    @Override
    public Order create(Order o) {
        try {
            new JsonIO<>(Order.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Order getById(Long id) {
        try {
            return new JsonIO<>(Order.class).read(String.format(IOConstant.JSON_OBJ_PATH, Order.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> get() {
        return null;
    }

    @Override
    public Order update(Order o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
