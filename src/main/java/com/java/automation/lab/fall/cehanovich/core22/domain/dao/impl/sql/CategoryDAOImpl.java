package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Category;
import com.java.automation.lab.fall.cehanovich.core22.domain.config.SessionFactory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.CategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;
import org.apache.ibatis.session.SqlSession;

import javax.xml.bind.JAXBException;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private final static String namespace = "category_mapper";
    private static CategoryDAOImpl instance;

    public synchronized static CategoryDAOImpl getInstance() {
        if (instance==null) {
            instance = new CategoryDAOImpl();
        }
        return instance;
    }

    private CategoryDAOImpl() {

    }

    @Override
    public Category create(Category o) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", o);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }

    @Override
    public Category getById(Long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Category o = sqlSession.selectOne(namespace + "getById", id);
        sqlSession.close();
        return o;
    }

    @Override
    public List<Category> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Category> o = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return o;
    }

    @Override
    public Category update(Category o) {
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
