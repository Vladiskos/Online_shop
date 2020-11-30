package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Variation;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.VariationDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;

import javax.xml.bind.JAXBException;
import java.util.List;

public class VariationDAOImpl implements VariationDAO {
    private static VariationDAOImpl instance;

    public synchronized static VariationDAOImpl getInstance() {
        if (instance==null) {
            instance = new VariationDAOImpl();
        }
        return instance;
    }

    private VariationDAOImpl() {

    }

    @Override
    public Variation create(Variation o) {
        try {
            new XMLIO<>(Variation.class).write(o, String.format(IOConstant.XML_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Variation getById(Long id) {
        try {
            return new XMLIO<>(Variation.class).read(String.format(IOConstant.XML_OBJ_PATH, Variation.class.getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Variation> get() {
        return null;
    }

    @Override
    public Variation update(Variation o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
