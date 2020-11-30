package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RGB;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RGBDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;

import javax.xml.bind.JAXBException;
import java.util.List;

public class RGBDAOImpl implements RGBDAO {
    private static RGBDAOImpl instance;

    public synchronized static RGBDAOImpl getInstance() {
        if (instance==null) {
            instance = new RGBDAOImpl();
        }
        return instance;
    }

    private RGBDAOImpl() {

    }

    @Override
    public RGB create(RGB o) {
        try {
            new XMLIO<>(RGB.class).write(o, String.format(IOConstant.XML_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public RGB getById(Long id) {
        try {
            return new XMLIO<>(RGB.class).read(String.format(IOConstant.XML_OBJ_PATH, RGB.class.getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RGB> get() {
        return null;
    }

    @Override
    public RGB update(RGB o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
