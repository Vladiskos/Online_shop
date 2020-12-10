package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Subcategory;
import com.java.automation.lab.fall.cehanovich.core22.domain.config.SessionFactory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.SubcategoryDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;
import org.apache.ibatis.session.SqlSession;

import javax.xml.bind.JAXBException;
import java.util.List;

public class SubcategoryDAOImpl implements SubcategoryDAO {
    private final static String namespace = "subcategory_mapper";
    private static SubcategoryDAOImpl instance;

    public synchronized static SubcategoryDAOImpl getInstance() {
        if (instance==null) {
            instance = new SubcategoryDAOImpl();
        }
        return instance;
    }

    private SubcategoryDAOImpl() {

    }

    @Override
    public Subcategory create(Subcategory o) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", o);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }

    @Override
    public Subcategory getById(Long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Subcategory o = sqlSession.selectOne(namespace + "getById", id);
        sqlSession.close();
        return o;
    }

    @Override
    public List<Subcategory> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Subcategory> o = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return o;
    }

    @Override
    public Subcategory update(Subcategory o) {
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
