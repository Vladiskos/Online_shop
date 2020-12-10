package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.config.SessionFactory;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.AddressDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;
import org.apache.ibatis.session.SqlSession;

import javax.xml.bind.JAXBException;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    private final static String namespace = "address_mapper";
    private static AddressDAOImpl instance;

    public static synchronized AddressDAOImpl getInstance() {
        if (instance==null) {
            instance = new AddressDAOImpl();
            System.out.println();
        }
        return instance;
    }

    private AddressDAOImpl() {

    }
    @Override
    public Address create(Address o) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", o);
        sqlSession.commit();
        sqlSession.close();
        return null;
    }

    @Override
    public Address getById(Long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Address o = sqlSession.selectOne(namespace + "getById", id);
        sqlSession.close();
        return o;
    }

    @Override
    public List<Address> get() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Address> as = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return as;
    }

    @Override
    public Address update(Address o) {
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
