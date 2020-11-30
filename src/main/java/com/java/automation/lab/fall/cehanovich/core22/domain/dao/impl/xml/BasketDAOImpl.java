package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Basket;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BasketDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;

import javax.xml.bind.JAXBException;
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
            new XMLIO<>(Basket.class).write(o, String.format(IOConstant.XML_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Basket getById(Long id) {
        try {
            return new XMLIO<>(Basket.class).read(String.format(IOConstant.XML_OBJ_PATH, Basket.class.getCanonicalName()));
        } catch (JAXBException e) {
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
