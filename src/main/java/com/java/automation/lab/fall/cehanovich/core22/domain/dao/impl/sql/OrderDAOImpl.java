package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Order;
import com.java.automation.lab.fall.cehanovich.core22.domain.config.SessionFactory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.OrderDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;
import org.apache.ibatis.session.SqlSession;

import javax.xml.bind.JAXBException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private final static String namespace = "order_mapper";
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
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", o);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }

    @Override
    public Order getById(Long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Order o = sqlSession.selectOne(namespace + "getById", id);
        sqlSession.close();
        return o;
    }

    @Override
    public List<Order> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Order> o = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return o;
    }

    @Override
    public Order update(Order o) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", o);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }

    @Override
    public void deleteById(Long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".deleteById", id);
        sqlSession.commit();
        sqlSession.close();
    }
}
