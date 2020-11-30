package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.OrderDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.OrderDAOImpl;

import java.math.BigDecimal;
import java.util.List;

public class OrderService extends BaseService{
    private static final OrderDAO DAO = ORDER_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static Order createOrder(int id, Basket basket, String description, BigDecimal tax) {
        return DAO.create(new Order(id, basket, description, tax));
    }

    public static Order getOrderById(Long id) {
        return DAO.getById(id);
    }

    public static List<Order> get() {
        return DAO.get();
    }

    public static Order update(Order o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
