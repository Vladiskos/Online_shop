package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Order;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.OrderDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
    public synchronized Order create(Order order) {
        new ObjectIO<Order>().write(order, IOConstant.RQ_PATH);
        return order;
    }

    @Override
    public synchronized Order update(Order newOrder) {
        Order updated = new Order(newOrder.getId(), newOrder.getBasket(), newOrder.getDescription(), newOrder.getTax());
        return updated;
    }

    @Override
    public Order getById(Long id) {
        return new ObjectIO<Order>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Order> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
