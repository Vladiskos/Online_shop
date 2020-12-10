package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Product;
import com.java.automation.lab.fall.cehanovich.core22.domain.config.SessionFactory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ProductDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;
import org.apache.ibatis.session.SqlSession;

import javax.xml.bind.JAXBException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final static String namespace = "product_mapper";
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
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", o);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }

    @Override
    public Product getById(Long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Product o = sqlSession.selectOne(namespace + "getById", id);
        sqlSession.close();
        return o;
    }

    @Override
    public List<Product> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Product> o = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return o;
    }

    @Override
    public Product update(Product o) {
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
